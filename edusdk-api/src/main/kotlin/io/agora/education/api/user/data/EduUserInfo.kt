package io.agora.education.api.user.data

enum class EduUserRole(value: Int) {
    TEACHER(1),
    STUDENT(2)
}

open class EduUserInfo(
        val userUuid: String,
        val userName: String,
        val role: EduUserRole
)
