package io.agora.education.api.room.data

// TODO NEED CONFIRM
enum class EduRoomState {
    START,
    STOP
}

data class EduRoomStatus(
        val courseState: EduRoomState,
        val startTime: Long,
        var isStudentChatAllowed: Boolean,
        var onlineUsersCount: Int
)

enum class RoomStatusEvent {
    STUDENT_CHAT,
    COURSE_STATE,
}
