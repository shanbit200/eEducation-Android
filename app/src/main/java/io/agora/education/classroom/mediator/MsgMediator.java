package io.agora.education.classroom.mediator;

import androidx.annotation.NonNull;

import io.agora.education.classroom.bean.msg.ChannelMsg;
import io.agora.education.classroom.bean.msg.PeerMsg;
import io.agora.education.classroom.bean.user.User;
import io.agora.sdk.manager.RtmManager;

public class MsgMediator {

    public static void sendMessageToPeer(@NonNull User user, @NonNull PeerMsg msg) {
        RtmManager.instance().sendMessageToPeer(String.valueOf(user.uid), msg.toJsonString());
    }

    public static void sendMessage(@NonNull ChannelMsg msg) {
        RtmManager.instance().sendMessage(msg.toJsonString());
    }

}
