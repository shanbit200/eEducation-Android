package io.agora.education.message

import io.agora.education.user.User
import kotlin.properties.Delegates

open class Message {
    var timestamp by Delegates.notNull<Long>()

    lateinit var fromUser: User
}
