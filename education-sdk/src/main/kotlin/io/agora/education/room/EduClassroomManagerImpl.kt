package io.agora.education.room

import io.agora.education.edumanager.EduStream
import io.agora.education.edumanager.EduUser
import io.agora.education.user.EduStudentService
import io.agora.education.user.EduTeacherService

class EduClassroomManagerImpl constructor() : EduClassroomManager() {
    override fun getLocalUser(success: (user: EduUser) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getClassroomInfo(success: (classRoom: EduClassroom) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getStudentCount(success: (count: Int) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getTeacherCount(success: (count: Int) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getTeacherList(success: (count: Int, users: Array<EduUser>) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getStudentList(fromIndex: Int, toIndex: Int, success: (count: Int, users: Array<EduUser>) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getFullUserList(success: (count: Int, users: Array<EduUser>) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getFullStreamList(success: (count: Int, streams: Array<EduStream>) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun joinClassroomAsTeacher(classroomJoinOptions: EduClassroomJoinOptions, success: (teacherService: EduTeacherService) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun joinClassroomAsStudent(classroomJoinOptions: EduClassroomJoinOptions, success: (studentService: EduStudentService) -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun leaveClassroom(success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }
}