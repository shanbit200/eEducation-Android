package io.agora.education.user

enum class UserRole(val value: Int) {
    TEACHER(1),
    STUDENT(2)
}

data class User internal constructor(
        val userId: String,
        val userName: String,
        val role: UserRole,
        val userUuid: String
)
