package io.agora.education.user

import io.agora.education.stream.Stream

abstract class TeacherServiceLocal(localUser: User) : LocalUserService(localUser) {
    abstract fun updateCourseState()

    abstract fun enableAllStudentChat(enable: Boolean)

    abstract fun enableStudentChat(enable: Boolean, user: User)

    abstract fun startShareScreen(streamId: String): Stream

    abstract fun stopShareScreen(streamId: String): Stream

    abstract fun startCamera(user: User)

    abstract fun stopCamera(user: User)

    abstract fun startMicrophone(user: User)

    abstract fun stopMicrophone(user: User)
}
