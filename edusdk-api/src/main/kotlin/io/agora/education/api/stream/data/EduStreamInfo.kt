package io.agora.education.api.stream.data

import io.agora.education.api.user.data.EduUserInfo

enum class VideoSourceType {
    CAMERA,
    SCREEN
}

data class EduStreamInfo(
        var streamUuid: String,
        var streamName: String,
        private var streamId: Int,
        val videoSourceType: VideoSourceType,
        var hasVideo: Boolean,
        var hasAudio: Boolean,

        val publisher: EduUserInfo
)
