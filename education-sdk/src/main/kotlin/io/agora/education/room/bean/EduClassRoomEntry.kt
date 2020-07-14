package io.agora.education.room.bean

class EduClassRoomEntry constructor(private var userId: String,
                                    var userUuid: String, var userToken: String,
                                    var rtmToken: String, var rtcToken:String) {
}