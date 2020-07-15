package io.agora.education.api.room

import io.agora.education.api.EduCallback
import io.agora.education.api.board.EduBoard
import io.agora.education.api.record.EduRecord
import io.agora.education.api.room.data.EduRoomInfo
import io.agora.education.api.room.data.RoomJoinOptions
import io.agora.education.api.room.data.EduRoomStatus
import io.agora.education.api.room.listener.EduRoomEventListener
import io.agora.education.api.user.EduStudent
import io.agora.education.api.user.EduTeacher
import io.agora.education.api.user.EduUser

abstract class EduRoom {
    lateinit var roomInfo: EduRoomInfo
    lateinit var roomStatus: EduRoomStatus

    lateinit var localUser: EduUser
    lateinit var board: EduBoard
    lateinit var record: EduRecord

    var eventListener: EduRoomEventListener? = null

    abstract fun joinAsTeacher(options: RoomJoinOptions, callback: EduCallback<EduTeacher>)

    abstract fun joinAsStudent(options: RoomJoinOptions, callback: EduCallback<EduStudent>)

    abstract fun leave(callback: EduCallback<Unit>)
}
