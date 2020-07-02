package io.agora.education.impl

import io.agora.education.stream.LocalStream
import io.agora.education.user.TeacherService
import io.agora.education.user.User

class TeacherServiceImpl internal constructor(
        localUser: User
) : LocalUserServiceImpl(localUser), TeacherService {
    override fun updateCourseState() {
        TODO("Not yet implemented")
    }

    override fun enableAllStudentChat(enable: Boolean) {
        TODO("Not yet implemented")
    }

    override fun enableStudentChat(enable: Boolean, user: User) {
        TODO("Not yet implemented")
    }

    override fun startShareScreen(streamId: String): LocalStream {
        TODO("Not yet implemented")
    }

    override fun stopShareScreen(stream: LocalStream) {
        TODO("Not yet implemented")
    }

    override fun startCamera(user: User) {
        TODO("Not yet implemented")
    }

    override fun stopCamera(user: User) {
        TODO("Not yet implemented")
    }

    override fun startMicrophone(user: User) {
        TODO("Not yet implemented")
    }

    override fun stopMicrophone(user: User) {
        TODO("Not yet implemented")
    }
}
