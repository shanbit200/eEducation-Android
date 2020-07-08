package io.agora.education.classroom

enum class CourseState {
    IDLE,
    BEGAN,
    ENDED
}

data class RoomStatus internal constructor(
        val courseState: CourseState,
        val realBeginTimestamp: Long,
        val forbiddenRoomMessage: Boolean,
        val onlineUserCount: Int
)
