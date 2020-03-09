package io.agora.education.service.bean.response;

import java.util.List;

import io.agora.education.classroom.bean.channel.User;

public class RecordRes {

    public String recordId;
    public int uid;
    public long startTime;
    public long endTime;
    public String roomId;
    public String boardId;
    public String boardToken;
    public List<RecordDetail> recordDetails;

    public static class RecordDetail {
        public String userId;
        public String userName;
        @User.Role
        public int role;
        public String url;
    }

}
