package io.agora.education.classroom.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import butterknife.BindView;
import io.agora.education.R;
import io.agora.education.base.BaseFragment;
import io.agora.education.classroom.BaseClassActivity;
import io.agora.education.classroom.adapter.MessageListAdapter;
import io.agora.education.classroom.bean.msg.ChannelMsg;
import io.agora.education.classroom.mediator.MsgMediator;

public class ChatRoomFragment extends BaseFragment implements OnItemChildClickListener, View.OnKeyListener {

    @BindView(R.id.rcv_msg)
    protected RecyclerView rcv_msg;
    @BindView(R.id.edit_send_msg)
    protected EditText edit_send_msg;

    private MessageListAdapter adapter;
    private boolean isMuteAll;
    private boolean isMuteLocal;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_chatroom;
    }

    @Override
    protected void initData() {
        adapter = new MessageListAdapter();
        adapter.setOnItemChildClickListener(this);
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setStackFromEnd(true);
        rcv_msg.setLayoutManager(layoutManager);
        rcv_msg.setAdapter(adapter);
        edit_send_msg.setOnKeyListener(this);
    }

    public void setMuteAll(boolean isMuteAll) {
        this.isMuteAll = isMuteAll;
        setEditTextEnable(!(this.isMuteAll || isMuteLocal));
    }

    public void setMuteLocal(boolean isMuteLocal) {
        this.isMuteLocal = isMuteLocal;
        setEditTextEnable(!(this.isMuteAll || isMuteLocal));
    }

    private void setEditTextEnable(boolean isEnable) {
        runOnUiThread(() -> {
            if (edit_send_msg != null) {
                edit_send_msg.setEnabled(isEnable);
                if (isEnable) {
                    edit_send_msg.setHint(R.string.hint_im_message);
                } else {
                    edit_send_msg.setHint(R.string.chat_muting);
                }
            }
        });
    }

    public void addMessage(ChannelMsg.ChatMsg chatMsg) {
        runOnUiThread(() -> {
            if (rcv_msg != null) {
                adapter.addData(chatMsg);
                rcv_msg.scrollToPosition(adapter.getItemPosition(chatMsg));
            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.tv_content) {
            Bundle bundle = getArguments();
            if (bundle != null && bundle.containsKey(BaseClassActivity.WHITEBOARD_ROOM_TOKEN)) {
                Object object = adapter.getItem(position);
                if (object instanceof ChannelMsg.ReplayMsg) {
                    ChannelMsg.ReplayMsg msg = (ChannelMsg.ReplayMsg) object;
                    // TODO
//                    if (!TextUtils.isEmpty(msg.link)) {
//                        String[] strings = msg.link.split("/");
//                        String uuid = strings[2];
//                        long startTime = Long.parseLong(strings[3]);
//                        long endTime = Long.parseLong(strings[4]);
//                        Intent intent = new Intent(context, ReplayActivity.class);
//                        intent.putExtra(ReplayActivity.WHITEBOARD_UID, uuid);
//                        intent.putExtra(BaseClassActivity.WHITEBOARD_ROOM_TOKEN, bundle.getString(BaseClassActivity.WHITEBOARD_ROOM_TOKEN));
//                        intent.putExtra(ReplayActivity.WHITEBOARD_START_TIME, startTime);
//                        intent.putExtra(ReplayActivity.WHITEBOARD_END_TIME, endTime);
//                        intent.putExtra(ReplayActivity.WHITEBOARD_URL, msg.url);
//                        startActivity(intent);
//                    }
                }
            }
        }
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if (!edit_send_msg.isEnabled()) {
            return false;
        }
        String text = edit_send_msg.getText().toString();
        if (KeyEvent.KEYCODE_ENTER == keyCode && KeyEvent.ACTION_DOWN == event.getAction() && text.trim().length() > 0) {
            if (context instanceof BaseClassActivity) {
                ChannelMsg.ChatMsg chatMsg = new ChannelMsg.ChatMsg(((BaseClassActivity) context).getMyUserName(), text);
                ChannelMsg msg = new ChannelMsg(chatMsg);
                MsgMediator.sendMessage(msg);
                addMessage(chatMsg);
                edit_send_msg.setText("");
            }
            return true;
        }
        return false;
    }

}
