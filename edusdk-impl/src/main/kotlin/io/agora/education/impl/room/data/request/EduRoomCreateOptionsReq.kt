package io.agora.education.impl.room.data.request

import io.agora.education.api.room.data.RoomCreateOptions
import io.agora.education.api.room.data.RoomProperty.Companion.KEY_STREAM_LIMIT
import io.agora.education.api.room.data.RoomProperty.Companion.KEY_STUDENT_LIMIT
import io.agora.education.api.room.data.RoomProperty.Companion.KEY_TEACHER_LIMIT

class RoomCreateOptionsReq constructor(){
    lateinit var roomUuid: String
    lateinit var roomName: String
    lateinit var roomLimitConfig: RoomLimitConfig

    constructor(roomUuid: String, roomName: String,
                roomLimitConfig: RoomLimitConfig) : this() {
        this.roomUuid = roomUuid
        this.roomName = roomName
        this.roomLimitConfig = roomLimitConfig
    }

    companion object {
        fun convertToSelf(roomCreateOptions: RoomCreateOptions): RoomCreateOptionsReq {
            var roomCreateOptionsReq = RoomCreateOptionsReq()
            roomCreateOptionsReq.roomUuid = roomCreateOptions.roomUuid
            roomCreateOptionsReq.roomName = roomCreateOptions.roomName
            var roomLimitConfig = RoomLimitConfig()
            var roomProperties = roomCreateOptions.properties
            for (roomProperty in roomProperties) {
                when (roomProperty.value) {
                    KEY_TEACHER_LIMIT -> {
                        roomLimitConfig.teacherLimit = roomProperty.value!!.toInt()
                    }
                    KEY_STUDENT_LIMIT -> {
                        roomLimitConfig.studentLimit = roomProperty.value!!.toInt()
                    }
                    KEY_STREAM_LIMIT -> {
                        roomLimitConfig.streamLimit = roomProperty.value!!.toInt()
                    }
                }
            }
            roomCreateOptionsReq.roomLimitConfig == roomLimitConfig
            return roomCreateOptionsReq
        }
    }
}

class RoomLimitConfig constructor() {
    var teacherLimit: Int = 0
    var studentLimit: Int = 0
    var streamLimit: Int  = 0

    constructor(teacherLimit: Int, studentLimit: Int, streamLimit: Int) : this() {
        this.teacherLimit = teacherLimit
        this.studentLimit = studentLimit
        this.streamLimit = streamLimit
    }

}