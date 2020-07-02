package io.agora.education.classroom

enum class ConnectionState {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    RECONNECTING,
    ABORTED
}

data class RoomStatus internal constructor(
        val courseState: Int,
        val startTime: Long,
        val muteAllChat: Int,
        val isRecording: Boolean,
        val recordId: String? = null,
        val recordingTime: Long? = null,
        val onlineUserCount: Int
)
