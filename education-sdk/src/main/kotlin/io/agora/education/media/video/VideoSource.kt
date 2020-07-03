package io.agora.education.media.video

import io.agora.education.media.MediaPublishState
import io.agora.education.media.MediaSource

enum class VideoSourceType {
    CAMERA,
    SCREEN_SHARING
}

open class VideoSource internal constructor(
        var type: VideoSourceType,
        override var state: MediaPublishState = MediaPublishState.IDLE
) : MediaSource
