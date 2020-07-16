package io.agora.education.impl.room

import io.agora.education.api.EduCallback
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.EduRoomInfo
import io.agora.education.api.room.data.EduRoomStatus
import io.agora.education.api.room.data.RoomJoinOptions
import io.agora.education.api.user.EduStudent
import io.agora.education.api.user.EduTeacher
import io.agora.rtc.models.ChannelMediaOptions
import io.agora.rte.RteEngineImpl

internal class EduRoomImpl(
        roomInfo: EduRoomInfo,
        roomStatus: EduRoomStatus
) : EduRoom(roomInfo, roomStatus) {
    init {
        RteEngineImpl.createChannel(roomInfo.roomUuid)
    }

    override fun joinAsTeacher(options: RoomJoinOptions, callback: EduCallback<EduTeacher>) {
        TODO("Not yet implemented")
    }

    override fun joinAsStudent(options: RoomJoinOptions, callback: EduCallback<EduStudent>) {
        TODO("Not yet implemented")
    }

    fun joinRte() {
        RteEngineImpl[""]?.join("", 0, ChannelMediaOptions())
    }

    override fun leave(callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }
}
