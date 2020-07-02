package io.agora.education.message

import io.agora.education.user.User

class TextMessage internal constructor(
        val text: String,
        timestamp: Long,
        fromUser: User
) : Message(timestamp, fromUser)
