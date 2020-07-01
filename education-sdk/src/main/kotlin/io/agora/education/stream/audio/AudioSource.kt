package io.agora.education.stream.audio

import kotlin.properties.Delegates

enum class AudioSourceType {
    MICROPHONE
}

class AudioSource {
    lateinit var type: AudioSourceType
    var enable by Delegates.notNull<Boolean>()
}
