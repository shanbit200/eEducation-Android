package io.agora.education.classroom

import io.agora.education.stream.SubscribeOption
import io.agora.education.stream.video.VideoEncoderConfig
import kotlin.properties.Delegates

enum class ConnectionState {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    RECONNECTING,
    ABORTED
}

data class CreateRoomParams(
        var userName: String,
        var userUuid: String,
        var roomName: String,
        var roomUUid: String
)

data class CreateRoomConfig(
        var teacherLimit: Int,
        var studentLimit: Int,
        var streamLimit: Int = 17
)

data class JoinRoomParams(
        var subscribeOption: SubscribeOption = SubscribeOption(),
        var videoEncoderConfig: VideoEncoderConfig = VideoEncoderConfig()
)

class RoomInfo {
    lateinit var roomId: String
        internal set
    lateinit var roomUuid: String
        internal set
    lateinit var roomName: String
        internal set
    lateinit var channelName: String
        internal set
    var type by Delegates.notNull<Int>()
        internal set
}

class RoomStatus {
    var courseState by Delegates.notNull<Int>()
        internal set
    var startTime by Delegates.notNull<Long>()
        internal set
    var muteAllChat by Delegates.notNull<Int>()
        internal set
    var isRecording by Delegates.notNull<Int>()
        internal set
    lateinit var recordId: String
        internal set
    var recordingTime by Delegates.notNull<Long>()
        internal set
    var onlineUserCount by Delegates.notNull<Int>()
        internal set
}

class Classroom {
    lateinit var roomInfo: RoomInfo
        internal set
    lateinit var roomStatus: RoomStatus
        internal set
}
