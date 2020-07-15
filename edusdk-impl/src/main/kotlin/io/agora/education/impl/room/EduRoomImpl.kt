package io.agora.education.impl.room

import io.agora.education.api.EduCallback
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.EduRoomInfo
import io.agora.education.api.room.data.EduRoomStatus
import io.agora.education.api.room.data.RoomJoinOptions
import io.agora.education.api.user.EduStudent
import io.agora.education.api.user.EduTeacher
import io.agora.education.api.user.EduUser
import io.agora.education.impl.user.EduStudentImpl
import io.agora.education.impl.user.EduTeacherImpl

internal class EduRoomImpl(
        roomInfo: EduRoomInfo,
        roomStatus: EduRoomStatus,
        localUser: EduUser
) : EduRoom(roomInfo, roomStatus, localUser) {
    override fun joinAsTeacher(options: RoomJoinOptions, callback: EduCallback<EduTeacher>) {
        callback.onSuccess(EduTeacherImpl())
        TODO("Not yet implemented")
    }

    override fun joinAsStudent(options: RoomJoinOptions, callback: EduCallback<EduStudent>) {
        callback.onSuccess(EduStudentImpl())
        TODO("Not yet implemented")
    }

    override fun leave(callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }
}
