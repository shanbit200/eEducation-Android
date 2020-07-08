package io.agora.education.media

enum class MediaPublishState {
    IDLE,
    NO_PUBLISH,
    PUBLISHING,
    PUBLISHED
}

internal interface MediaSource {
    var state: MediaPublishState
}
