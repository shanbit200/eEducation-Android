package io.agora.education.room.bean.response

import io.agora.education.room.bean.EduClassroom
import io.agora.education.room.bean.EduClassroomInfo
import io.agora.education.room.bean.EduClassroomStatus
import io.agora.education.room.enums.EduCourseState

class EduClassRoomRes constructor(var eduClassroomInfoRes: EduClassroomInfoRes,
                                  var eduClassroomStatusRes: EduClassroomStatusRes) {

    fun convertToEduClassroom(): EduClassroom {
        var eduClassroom = EduClassroom()
        var eduClassroomStatus = EduClassroomStatus()
        eduClassroomStatus.courseState = eduClassroomStatusRes.courseState
        eduClassroomStatus.startTime = eduClassroomStatusRes.startTime
        eduClassroomStatus.isStudentChatAllowed = eduClassroomStatusRes.muteAllChat
        eduClassroomStatus.isStudentAudioAllowed = eduClassroomStatusRes.muteAllAudio
        eduClassroomStatus.isStudentVideoAllowed = eduClassroomStatusRes.muteAllVideo
        eduClassroomStatus.onlineUsersCount = eduClassroomStatusRes.onlineUsers
        eduClassroom.eduClassroomStatus = eduClassroomStatus
        var eduClassroomInfo = EduClassroomInfo(eduClassroomInfoRes.roomId,
                                                eduClassroomInfoRes.roomUuid,
                                                eduClassroomInfoRes.roomName)
        eduClassroom.eduClassroomInfo = eduClassroomInfo
        return eduClassroom
    }
}

class EduClassroomStatusRes constructor() {
    var courseState: EduCourseState = EduCourseState.EduCourseStateStop
    var startTime: Long = System.currentTimeMillis()
    var muteAllChat: Boolean = false
    var muteAllAudio: Boolean = false
    var muteAllVideo: Boolean = false
    var onlineUsers: Int = 0

    constructor(courseState: EduCourseState, startTime: Long, muteAllChat: Boolean,
                muteAllAudio: Boolean,
                muteAllVideo: Boolean,
                onlineUsers: Int) : this() {
        this.courseState = courseState
        this.startTime = startTime
        this.muteAllChat = muteAllChat
        this.muteAllAudio = muteAllAudio
        this.muteAllVideo = muteAllVideo
        this.onlineUsers = onlineUsers
    }
}

class EduClassroomInfoRes constructor() {
    lateinit var roomId: String
    lateinit var roomUuid: String
    lateinit var roomName: String

    constructor(roomId: String, roomUuid: String, roomName: String) : this() {
        this.roomId = roomId
        this.roomUuid = roomUuid
        this.roomName = roomName
    }
}