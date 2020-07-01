package io.agora.education.stream.video

import kotlin.properties.Delegates

enum class VideoSourceType {
    CAMERA,
    SCREEN_SHARING
}

class VideoSource {
    lateinit var type: VideoSourceType
    var enable by Delegates.notNull<Boolean>()
}
