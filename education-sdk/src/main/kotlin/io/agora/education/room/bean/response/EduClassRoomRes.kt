package io.agora.education.room.bean.response

import io.agora.education.room.bean.EduClassroom
import io.agora.education.room.bean.EduClassroomInfo
import io.agora.education.room.bean.EduClassroomStatus
import io.agora.education.room.enums.EduCourseState

class EduClassRoomRes constructor(var eduClassroomInfo: EduClassroomInfo,
                                  var eduClassroomStatusRes: EduClassroomStatusRes) {

    fun convertToEduClassroom(): EduClassroom {
        var eduClassroomStatus = EduClassroomStatus()
        eduClassroomStatus.courseState = eduClassroomStatusRes.courseState
        eduClassroomStatus.startTime = eduClassroomStatusRes.startTime
        eduClassroomStatus.isStudentChatAllowed = eduClassroomStatusRes.muteAllChat
        eduClassroomStatus.isStudentAudioAllowed = eduClassroomStatusRes.muteAllAudio
        eduClassroomStatus.isStudentVideoAllowed = eduClassroomStatusRes.muteAllVideo
        eduClassroomStatus.onlineUsersCount = eduClassroomStatusRes.onlineUsers
        var eduClassroom = EduClassroom()
        eduClassroom.eduClassroomInfo = eduClassroomInfo
        eduClassroom.eduClassroomStatus = eduClassroomStatus
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