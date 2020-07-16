package io.agora.education.impl.room.data

import io.agora.education.api.room.data.EduRoomInfo

class EduRoomInfoImpl(private val roomId: String?, roomUuid: String, roomName: String)
    : EduRoomInfo(roomUuid, roomName) {

}