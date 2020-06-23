package io.agora.education.classroom.strategy.context;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;

import io.agora.base.callback.Callback;
import io.agora.base.callback.ThrowableCallback;
import io.agora.education.classroom.bean.channel.User;
import io.agora.education.classroom.strategy.ChannelStrategy;
import io.agora.rtc.Constants;
import io.agora.sdk.manager.RtcManager;

public class OneToOneClassContext extends ClassContext {

    private final static int MAX_USER_NUM = 2;

    OneToOneClassContext(Context context, ChannelStrategy strategy) {
        super(context, strategy);
    }

    @Override
    @Deprecated
    public void checkChannelEnterable(@NonNull Callback<Boolean> callback) {
        channelStrategy.queryChannelInfo(new ThrowableCallback<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                channelStrategy.queryOnlineUserNum(new ThrowableCallback<Integer>() {
                    @Override
                    public void onSuccess(Integer integer) {
                        if (callback != null) {
                            callback.onSuccess(integer < MAX_USER_NUM);
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        if (callback != null && callback instanceof ThrowableCallback) {
                            ((ThrowableCallback) callback).onFailure(throwable);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Throwable throwable) {
                if (callback != null && callback instanceof ThrowableCallback) {
                    ((ThrowableCallback) callback).onFailure(throwable);
                }
            }
        });
    }

    @Override
    void preConfig() {
        RtcManager.instance().setChannelProfile(Constants.CHANNEL_PROFILE_LIVE_BROADCASTING);
        RtcManager.instance().setClientRole(Constants.CLIENT_ROLE_BROADCASTER);
        RtcManager.instance().enableDualStreamMode(false);
    }

    @Override
    public void onLocalChanged(User local) {
        super.onLocalChanged(local);
        if (classEventListener instanceof OneToOneClassEventListener) {
            runListener(new Runnable() {
                @Override
                public void run() {
                    ((OneToOneClassEventListener) classEventListener).onLocalMediaChanged(local);
                }
            });
        }
    }

    @Override
    public void onCoVideoUsersChanged(List<User> users) {
        super.onCoVideoUsersChanged(users);
        if (classEventListener instanceof OneToOneClassEventListener) {
            for (User user : users) {
                if (user.isTeacher()) {
                    runListener(new Runnable() {
                        @Override
                        public void run() {
                            ((OneToOneClassEventListener) classEventListener).onTeacherMediaChanged(user);
                        }
                    });
                    return;
                }
            }
        }
    }

    public interface OneToOneClassEventListener extends ClassEventListener {
        void onTeacherMediaChanged(User user);

        void onLocalMediaChanged(User user);
    }

}
