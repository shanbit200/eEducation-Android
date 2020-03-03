package io.agora.education;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTouch;
import io.agora.base.Callback;
import io.agora.base.ToastManager;
import io.agora.base.network.RetrofitManager;
import io.agora.education.base.BaseActivity;
import io.agora.education.broadcast.DownloadReceiver;
import io.agora.education.classroom.BaseClassActivity;
import io.agora.education.classroom.LargeClassActivity;
import io.agora.education.classroom.OneToOneClassActivity;
import io.agora.education.classroom.SmallClassActivity;
import io.agora.education.classroom.annotation.ClassType;
import io.agora.education.classroom.bean.channel.ChannelInfo;
import io.agora.education.classroom.bean.user.Student;
import io.agora.education.classroom.strategy.context.ClassContext;
import io.agora.education.classroom.strategy.context.ClassContextFactory;
import io.agora.education.service.CommonService;
import io.agora.education.service.RoomService;
import io.agora.education.service.bean.ResponseBody;
import io.agora.education.service.bean.request.RoomEntryReq;
import io.agora.education.service.bean.response.AppConfig;
import io.agora.education.service.bean.response.AppVersion;
import io.agora.education.service.bean.response.RoomEntryRes;
import io.agora.education.service.bean.response.RoomInfo;
import io.agora.education.service.bean.response.UserInfo;
import io.agora.education.util.AppUtil;
import io.agora.education.util.UUIDUtil;
import io.agora.education.widget.ConfirmDialog;
import io.agora.education.widget.PolicyDialog;
import io.agora.rtc.Constants;
import io.agora.sdk.manager.RtcManager;
import io.agora.sdk.manager.RtmManager;

public class MainActivity extends BaseActivity {

    private final int REQUEST_CODE_DOWNLOAD = 100;
    private final int REQUEST_CODE_RTC = 101;

    @BindView(R.id.et_room_name)
    protected EditText et_room_name;
    @BindView(R.id.et_your_name)
    protected EditText et_your_name;
    @BindView(R.id.et_room_type)
    protected EditText et_room_type;
    @BindView(R.id.card_room_type)
    protected CardView card_room_type;

    private DownloadReceiver receiver;
    private CommonService service;
    private String url;
    private boolean isJoining;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        receiver = new DownloadReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        filter.setPriority(IntentFilter.SYSTEM_LOW_PRIORITY);
        registerReceiver(receiver, filter);

        service = RetrofitManager.instance().getService(BuildConfig.API_BASE_URL, CommonService.class);
        checkVersion();
        getConfig();
    }

    @Override
    protected void initView() {
        new PolicyDialog().show(getSupportFragmentManager(), null);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        ChannelInfo.CONFIG = null;
        RtmManager.instance().reset();
        super.onDestroy();
    }

    private void checkVersion() {
        service.appVersion("edu-demo").enqueue(new RetrofitManager.Callback<>(0, new Callback<ResponseBody<AppVersion>>() {
            @Override
            public void onSuccess(ResponseBody<AppVersion> res) {
                AppVersion version = res.data;
                if (version != null && version.forcedUpgrade != 0) {
                    showAppUpgradeDialog(version.upgradeUrl, version.forcedUpgrade == 2);
                }
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }));
    }

    private void showAppUpgradeDialog(String url, boolean isForce) {
        this.url = url;
        String content = getString(R.string.app_upgrade);
        ConfirmDialog.DialogClickListener listener = new ConfirmDialog.DialogClickListener() {
            @Override
            public void clickConfirm() {
                if (AppUtil.checkAndRequestAppPermission(MainActivity.this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQUEST_CODE_DOWNLOAD)) {
                    receiver.downloadApk(MainActivity.this, url);
                }
            }

            @Override
            public void clickCancel() {

            }
        };
        ConfirmDialog dialog;
        if (isForce) {
            dialog = ConfirmDialog.singleWithButton(content, getString(R.string.upgrade), listener);
            dialog.setCancelable(false);
        } else {
            dialog = ConfirmDialog.normalWithButton(content, getString(R.string.later), getString(R.string.upgrade), listener);
        }
        dialog.show(getSupportFragmentManager(), null);
    }

    private void getConfig() {
        service.config().enqueue(new RetrofitManager.Callback<>(0, new Callback<ResponseBody<AppConfig>>() {
            @Override
            public void onSuccess(ResponseBody<AppConfig> res) {
                AppConfig config = res.data;
                RtcManager.instance().init(getApplicationContext(), config.appId);
                RtmManager.instance().init(getApplicationContext(), config.appId);
                ChannelInfo.CONFIG = config;
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }));
    }

    private void joinRoom() {
        if (isJoining) return;

        String roomNameStr = et_room_name.getText().toString();
        if (TextUtils.isEmpty(roomNameStr)) {
            ToastManager.showShort(R.string.room_name_should_not_be_empty);
            return;
        }

        String yourNameStr = et_your_name.getText().toString();
        if (TextUtils.isEmpty(yourNameStr)) {
            ToastManager.showShort(R.string.your_name_should_not_be_empty);
            return;
        }

        String roomTypeStr = et_room_type.getText().toString();
        if (TextUtils.isEmpty(roomTypeStr)) {
            ToastManager.showShort(R.string.room_type_should_not_be_empty);
            return;
        }

        int classType;
        if (roomTypeStr.equals(getString(R.string.one2one_class))) {
            classType = ClassType.ONE2ONE;
        } else if (roomTypeStr.equals(getString(R.string.small_class))) {
            classType = ClassType.SMALL;
        } else {
            classType = ClassType.LARGE;
        }

        if (ChannelInfo.CONFIG == null) {
            ToastManager.showShort(R.string.configuration_load_failed);
            getConfig();
            return;
        }

        isJoining = true;
        RetrofitManager.instance().getService(BuildConfig.API_BASE_URL, RoomService.class)
                .roomEntry(ChannelInfo.CONFIG.authorization, ChannelInfo.CONFIG.appId, new RoomEntryReq() {{
                    userName = yourNameStr;
                    roomName = roomNameStr;
                    type = classType;
                    uuid = UUIDUtil.getUUID();
                }})
                .enqueue(new RetrofitManager.Callback<>(0, new Callback<ResponseBody<RoomEntryRes>>() {
                    @Override
                    public void onSuccess(ResponseBody<RoomEntryRes> res) {
                        UserInfo user = res.data.user;
                        RoomInfo room = res.data.room;
                        RtmManager.instance().login(user.rtmToken, user.uid, new Callback<Void>() {
                            @Override
                            public void onSuccess(Void res) {
                                Intent intent = createIntent(room, user);
                                checkChannelEnterable(intent);
                            }

                            @Override
                            public void onFailure(Throwable throwable) {
                                ToastManager.showShort(throwable.getMessage());
                                isJoining = false;
                            }
                        });
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        ToastManager.showShort(throwable.getMessage());
                        isJoining = false;
                    }
                }));
    }

    private Intent createIntent(RoomInfo room, UserInfo user) {
        Intent intent = new Intent();
        if (room.type == ClassType.ONE2ONE) {
            intent.setClass(this, OneToOneClassActivity.class);
        } else if (room.type == ClassType.SMALL) {
            intent.setClass(this, SmallClassActivity.class);
        } else {
            intent.setClass(this, LargeClassActivity.class);
        }
        intent.putExtra(BaseClassActivity.ROOM_NAME, room.roomName)
                .putExtra(BaseClassActivity.CHANNEL_ID, room.channelName)
                .putExtra(BaseClassActivity.USER_NAME, user.userName)
                .putExtra(BaseClassActivity.USER_ID, user.uid)
                .putExtra(BaseClassActivity.CLASS_TYPE, room.type)
                .putExtra(BaseClassActivity.WHITEBOARD_ROOM_TOKEN, room.boardToken);
        return intent;
    }

    private void checkChannelEnterable(Intent intent) {
        int classType = intent.getIntExtra(BaseClassActivity.CLASS_TYPE, 0);
        String channelId = intent.getStringExtra(BaseClassActivity.CHANNEL_ID);
        String userName = intent.getStringExtra(BaseClassActivity.USER_NAME);
        int userId = intent.getIntExtra(BaseClassActivity.USER_ID, 0);
        ClassContext classContext = new ClassContextFactory(this)
                .getClassContext(classType, channelId, new Student(userId, userName, Constants.CLIENT_ROLE_AUDIENCE));
        classContext.checkChannelEnterable(new Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                classContext.release();
                if (aBoolean) {
                    startActivity(intent);
                } else {
                    ToastManager.showShort(R.string.the_room_is_full);
                }
                isJoining = false;
            }

            @Override
            public void onFailure(Throwable throwable) {
                classContext.release();
                ToastManager.showShort(R.string.get_channel_attr_failed);
                isJoining = false;
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                ToastManager.showShort(R.string.no_enough_permissions);
                return;
            }
        }
        switch (requestCode) {
            case REQUEST_CODE_DOWNLOAD:
                receiver.downloadApk(this, url);
                break;
            case REQUEST_CODE_RTC:
                joinRoom();
                break;
        }
    }

    @OnClick({R.id.iv_setting, R.id.et_room_type, R.id.btn_join, R.id.tv_one2one, R.id.tv_small_class, R.id.tv_large_class})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.btn_join:
                if (AppUtil.checkAndRequestAppPermission(this, new String[]{
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQUEST_CODE_RTC)) {
                    joinRoom();
                }
                break;
            case R.id.tv_one2one:
                et_room_type.setText(R.string.one2one_class);
                card_room_type.setVisibility(View.GONE);
                break;
            case R.id.tv_small_class:
                et_room_type.setText(R.string.small_class);
                card_room_type.setVisibility(View.GONE);
                break;
            case R.id.tv_large_class:
                et_room_type.setText(R.string.large_class);
                card_room_type.setVisibility(View.GONE);
                break;
        }
    }

    @OnTouch(R.id.et_room_type)
    public void onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (card_room_type.getVisibility() == View.GONE) {
                card_room_type.setVisibility(View.VISIBLE);
            } else {
                card_room_type.setVisibility(View.GONE);
            }
        }
    }

}
