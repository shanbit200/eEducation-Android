package io.agora.education.room

import io.agora.education.board.EduBoardService
import io.agora.education.edumanager.bean.EduStream
import io.agora.education.edumanager.bean.EduUser
import io.agora.education.record.EduRecordService
import io.agora.education.room.bean.EduClassroom
import io.agora.education.room.bean.EduClassroomJoinOptions
import io.agora.education.user.EduStudentService
import io.agora.education.user.EduTeacherService

abstract class EduClassroomManager constructor() {

    companion object {
        val KEYLIMITS: Array<String> = arrayOf("StreamLimit", "TeacherLimit", "StudentLimit")
//        const val kStreamLimit: String = "StreamLimit"
//        const val kTeacherLimit: String = "TeacherLimit"
//        const val kStudentLimit: String = "StudentLimit"
    }
    lateinit var boardService: EduBoardService
    lateinit var recordService: EduRecordService
    lateinit var eventListener: EduClassroomEventListener

    abstract fun getLocalUser(success: (user: EduUser) -> Unit,
                              failure: (throwable: Throwable) -> Unit)

    abstract fun getClassroomInfo(success: (classRoom: EduClassroom) -> Unit,
                                  failure: (throwable: Throwable) -> Unit)

    abstract fun getStudentCount(success: (count: Int) -> Unit,
                                 failure: (throwable: Throwable) -> Unit)

    abstract fun getTeacherCount(success: (count: Int) -> Unit,
                                 failure: (throwable: Throwable) -> Unit)

    abstract fun getTeacherList(success: (count: Int, users: Array<EduUser>) -> Unit,
                                failure: (throwable: Throwable) -> Unit)

    abstract fun getStudentList(fromIndex: Int, toIndex: Int,
                                success: (count: Int, users: Array<EduUser>) -> Unit,
                                failure: (throwable: Throwable) -> Unit)

    abstract fun getFullUserList(success: (count: Int, users: ArrayList<EduUser>) -> Unit,
                                 failure: (throwable: Throwable) -> Unit)

    abstract fun getFullStreamList(success: (count: Int, streams: ArrayList<EduStream>) -> Unit,
                                   failure: (throwable: Throwable) -> Unit)

    abstract fun joinClassroomAsTeacher(classroomJoinOptions: EduClassroomJoinOptions,
                                        success: (teacherService: EduTeacherService) -> Unit,
                                        failure: (throwable: Throwable) -> Unit)

    abstract fun joinClassroomAsStudent(classroomJoinOptions: EduClassroomJoinOptions,
                                        success: (studentService: EduStudentService) -> Unit,
                                        failure: (throwable: Throwable) -> Unit)

    abstract fun leaveClassroom(success: () -> Unit, failure: (throwable: Throwable) -> Unit)
}