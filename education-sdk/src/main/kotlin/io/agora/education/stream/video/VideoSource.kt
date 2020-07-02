package io.agora.education.stream.video

enum class VideoSourceType {
    CAMERA,
    SCREEN_SHARING
}

data class VideoSource internal constructor(
        var type: VideoSourceType,
        var enable: Boolean
)
