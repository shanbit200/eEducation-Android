package io.agora.education.classroom

import io.agora.education.stream.SubscribeOption
import io.agora.education.stream.video.VideoEncoderConfig
import io.agora.education.user.UserRole

data class RoomConfig(
        var roomUuid: String? = null,
        var roomName: String? = null,
        var teacherLimit: Int,
        var studentLimit: Int,
        var streamLimit: Int = 17
)

data class JoinOptions(
        var userUuid: String,
        var userName: String,
        var role: UserRole,
        var subscribeOption: SubscribeOption,
        var videoEncoderConfig: VideoEncoderConfig
) {
    constructor(userUuid: String, userName: String, role: UserRole) :
            this(userUuid, userName, role, SubscribeOption(), VideoEncoderConfig())
}

data class RoomInfo internal constructor(
        val roomId: String,
        val roomUuid: String,
        val roomName: String,
        val channelName: String
)

data class Classroom internal constructor(
        var roomInfo: RoomInfo,
        var roomStatus: RoomStatus
)
