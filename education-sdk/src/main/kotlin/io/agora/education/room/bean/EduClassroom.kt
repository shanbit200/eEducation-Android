package io.agora.education.room.bean

class EduClassroom constructor() {
    lateinit var eduClassroomInfo: EduClassroomInfo
    lateinit var eduClassroomStatus: EduClassroomStatus

    constructor(eduClassroomInfo: EduClassroomInfo, eduClassroomStatus: EduClassroomStatus): this() {
        this.eduClassroomInfo = eduClassroomInfo
        this.eduClassroomStatus = eduClassroomStatus
    }
}