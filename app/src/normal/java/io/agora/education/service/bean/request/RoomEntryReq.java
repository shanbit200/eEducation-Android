package io.agora.education.service.bean.request;

import io.agora.education.classroom.annotation.ClassType;

public class RoomEntryReq {

    public String userName;
    public String roomName;
    @ClassType
    public int type;
    public int role = 2; // 1.teacher 2.student
    public String uuid;

}
