package io.agora.education.user

enum class UserRole(val value: Int) {
    TEACHER(1),
    STUDENT(2)
}

enum class NetworkQuality {
    UNKNOWN,
    GOOD,
    POOR,
    BAD
}

open class User {
    lateinit var userId: String
        internal set
    lateinit var userName: String
        internal set
    lateinit var role: UserRole
        internal set
    lateinit var userUuid: String
        internal set
}
