package io.agora.education.media.video

import io.agora.rtc.video.VideoCanvas

enum class VideoRenderMode(val value: Int) {
    HIDDEN(VideoCanvas.RENDER_MODE_HIDDEN),
    FIT(VideoCanvas.RENDER_MODE_FIT)
}

data class VideoRenderConfig(
        var videoRenderMode: VideoRenderMode = VideoRenderMode.HIDDEN
)
