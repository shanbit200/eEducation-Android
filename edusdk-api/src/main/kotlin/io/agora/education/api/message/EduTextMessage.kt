package io.agora.education.api.message

open class EduTextMessage(
        val userUuid: String,
        val userName: String,
        val message: String,
        val timeStamp: Long
)
