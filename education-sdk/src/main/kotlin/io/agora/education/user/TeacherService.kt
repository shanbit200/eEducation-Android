package io.agora.education.user

import io.agora.education.stream.LocalStream

interface TeacherService : LocalUserService {
    fun updateCourseState()

    fun enableAllStudentChat(enable: Boolean)

    fun enableStudentChat(enable: Boolean, user: User)

    fun startShareScreen(streamId: String): LocalStream

    fun stopShareScreen(stream: LocalStream)

    fun startCamera(user: User)

    fun stopCamera(user: User)

    fun startMicrophone(user: User)

    fun stopMicrophone(user: User)
}
