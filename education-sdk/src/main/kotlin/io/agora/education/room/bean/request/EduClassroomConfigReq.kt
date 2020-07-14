package io.agora.education.room.bean.request

/**
 * roomName: 房间名称
 * roomUuid: 同一个appId下的房间唯一标示，同时也是rtc、rtm中的channelName*/
class EduClassroomConfigReq constructor(var roomUuid: String, var roomName: String,
                                        var roomConfig: RoomLimitConfig) {

}

/**老师上限，学生上限，流上限*/
class RoomLimitConfig constructor(var teacherLimit: Int, var studentLimit: Int,
                                  var streamLimit: Int) {

}