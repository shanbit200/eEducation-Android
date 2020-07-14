package io.agora.education.api.message

data class TextMessage internal constructor(
        val userId: String,
        val userName: String,
        val message: String,
        val timeStamp: Long
)
