package io.agora.education.room.bean

import io.agora.education.room.enums.EduCourseState

class EduClassroom constructor() {
    lateinit var eduClassroomInfo: EduClassroomInfo
    lateinit var eduClassroomStatus: EduClassroomStatus

    constructor(eduClassroomInfo: EduClassroomInfo, eduClassroomStatus: EduClassroomStatus) : this() {
        this.eduClassroomInfo = eduClassroomInfo
        this.eduClassroomStatus = eduClassroomStatus
    }
}

class EduClassroomStatus constructor() {
    var courseState: EduCourseState = EduCourseState.EduCourseStateStop
    var startTime: Long = System.currentTimeMillis()
    var isStudentChatAllowed: Boolean = false
    var isStudentAudioAllowed: Boolean = false
    var isStudentVideoAllowed: Boolean = false
    var onlineUsersCount: Int = 0

    constructor(courseState: EduCourseState, startTime: Long, isStudentChatAllowed: Boolean,
                isStudentAudioAllowed: Boolean,
                isStudentVideoAllowed: Boolean,
                onlineUsersCount: Int) : this() {
        this.courseState = courseState
        this.startTime = startTime
        this.isStudentChatAllowed = isStudentChatAllowed
        this.isStudentAudioAllowed = isStudentAudioAllowed
        this.isStudentVideoAllowed = isStudentVideoAllowed
        this.onlineUsersCount = onlineUsersCount
    }
}

class EduClassroomInfo constructor() {
    /**客户提供uuid，内部使用该uuid作为RTC/RTM 的channel name
     * 原来的roomId内部隐藏，不暴露给客户*/
    private lateinit var roomId: String
    lateinit var roomUuid: String
    lateinit var roomName: String

    constructor(roomId: String, roomUuid: String, roomName: String) : this() {
        this.roomId = roomId
        this.roomUuid = roomUuid
        this.roomName = roomName
    }
}