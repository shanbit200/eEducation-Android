package io.agora.education.api.stream.data

import io.agora.education.api.user.data.EduUserInfo

enum class VideoSourceType {
    CAMERA,
    SCREEN
}

open class EduStreamInfo(
        var streamUuid: String,
        var streamName: String,
        val videoSourceType: VideoSourceType,
        var hasVideo: Boolean,
        var hasAudio: Boolean,

        val publisher: EduUserInfo
)
