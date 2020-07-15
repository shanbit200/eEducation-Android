package io.agora.education.api.message

data class EduTextMessage internal constructor(
        val userId: String,
        val userName: String,
        val message: String,
        val timeStamp: Long
)
