package io.agora.education.api.user.data

enum class EduUserRole(value: Int) {
    TEACHER(1),
    STUDENT(2)
}

data class EduUserInfo constructor(
        private val userId: String,
        val userUuid: String,
        val userName: String,
        val role: EduUserRole
)
