package io.agora.education.media.audio

import io.agora.education.media.MediaPublishState

class MicAudioSource : AudioSource(AudioSourceType.MICROPHONE) {
    fun openMic(): MicAudioSource {
        state = MediaPublishState.IDLE
        return this
    }

    fun closeMic(): MicAudioSource {
        state = MediaPublishState.NO_PUBLISH
        return this
    }
}
