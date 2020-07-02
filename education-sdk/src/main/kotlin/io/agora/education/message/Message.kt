package io.agora.education.message

import io.agora.education.user.User

open class Message internal constructor(
        val timestamp: Long,
        val fromUser: User
)
