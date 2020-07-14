package io.agora.education.api.user.data

enum class EduUserRole(value: Int) {
    TEACHER(1),
    STUDENT(2)
}

data class EduUserInfo internal constructor(
        val userUuid: String,
        val userName: String,
        private val userId: String,
        val role: EduUserRole
)
