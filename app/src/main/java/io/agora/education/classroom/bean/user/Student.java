package io.agora.education.classroom.bean.user;

import androidx.annotation.NonNull;

import io.agora.education.classroom.bean.msg.ChannelMsg;
import io.agora.education.classroom.bean.msg.PeerMsg;
import io.agora.education.classroom.mediator.MsgMediator;
import io.agora.rtc.Constants;
import io.agora.sdk.annotation.ClientRole;

public class Student extends User implements Cloneable {

    public int chat; // enable chat -- 0: disable, 1: enable
    public int grant_board; // enable board -- 0: disable, 1: enable
    public transient boolean isGenerate; // create by local

    public Student(boolean isGenerate) {
        this.isGenerate = isGenerate;
    }

    public Student(int uid, String account, @ClientRole int role) {
        this.uid = uid;
        this.account = account;
        this.video = role == Constants.CLIENT_ROLE_AUDIENCE ? 0 : 1;
        this.audio = role == Constants.CLIENT_ROLE_AUDIENCE ? 0 : 1;
        this.chat = 1;
        this.isGenerate = true;
    }

    @NonNull
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public void sendCoVideoMsgToTeacher(@PeerMsg.CoVideoMsg.Cmd int cmd, Teacher teacher) {
        if (teacher == null) return;
        PeerMsg.CoVideoMsg coVideoMsg = new PeerMsg.CoVideoMsg(cmd, account);
        PeerMsg peerMsg = new PeerMsg(coVideoMsg);
        MsgMediator.sendMessageToPeer(teacher, peerMsg);
    }

    public void sendUpdateMsg(@ChannelMsg.UpdateMsg.Cmd int cmd) {
        ChannelMsg.UpdateMsg updateMsg = new ChannelMsg.UpdateMsg(cmd, account, uid);
        ChannelMsg channelMsg = new ChannelMsg(updateMsg);
        MsgMediator.sendMessage(channelMsg);
    }

}
