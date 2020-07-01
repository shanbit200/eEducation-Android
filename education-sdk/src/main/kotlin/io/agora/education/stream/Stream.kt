package io.agora.education.stream

import io.agora.education.stream.audio.AudioSource
import io.agora.education.stream.video.VideoSource
import io.agora.education.user.User

class Stream {
    lateinit var streamId: String
    lateinit var videoSource: VideoSource
    lateinit var audioSource: AudioSource

    lateinit var fromUser: User
}
