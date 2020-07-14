package io.agora.education.room.bean.response

import io.agora.education.room.bean.EduClassRoomEntry

/**userId: 用户Id(内部隐藏，不暴露给客户:还需要改)
 * userUuid: 房间内用户唯一id，同时也是用户加入rtm的uid
 * userToken: 用户token*/
class EduClassRoomEntryRes constructor(var userId: String, var userUuid: String,
                                       var userToken: String, var rtmToken: String,
                                       var rtcToken:String) {

    fun convertToEduClassroomEntry(): EduClassRoomEntry
    {
        var eduClassroomEntry = EduClassRoomEntry(userId, userUuid, userToken, rtmToken, rtcToken)
        return eduClassroomEntry
    }
}