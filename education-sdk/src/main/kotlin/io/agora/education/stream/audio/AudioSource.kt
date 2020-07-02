package io.agora.education.stream.audio

enum class AudioSourceType {
    MICROPHONE
}

data class AudioSource internal constructor(
        var type: AudioSourceType,
        var enable: Boolean
)
