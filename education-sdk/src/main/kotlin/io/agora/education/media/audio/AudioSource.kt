package io.agora.education.media.audio

import io.agora.education.media.MediaPublishState
import io.agora.education.media.MediaSource

enum class AudioSourceType {
    MICROPHONE
}

open class AudioSource internal constructor(
        var type: AudioSourceType,
        override var state: MediaPublishState = MediaPublishState.IDLE
) : MediaSource
