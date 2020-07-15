package io.agora.education.api.stream.data

import io.agora.education.api.user.data.EduUserInfo

enum class EduVideoSourceType(value: Int) {
    CAMERA(1),
    SCREEN(2)
}

enum class EduAudioSourceType(value: Int) {
    Microphone(1)
}

data class EduStreamInfo(
        var streamUuid: String,
        var streamName: String,
        private var streamId: Int,
        val eduVideoSourceType: EduVideoSourceType,
        val eduAudioSourceType: EduAudioSourceType,
        var hasVideo: Boolean,
        var hasAudio: Boolean,

        val publisher: EduUserInfo
)
