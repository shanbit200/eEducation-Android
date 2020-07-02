package io.agora.education.stream

import io.agora.education.stream.audio.AudioSource
import io.agora.education.stream.video.VideoSource
import io.agora.education.user.User

open class Stream internal constructor(
        open val streamId: String? = null,
        val videoSource: VideoSource,
        val audioSource: AudioSource,

        val fromUser: User
)

class LocalStream internal constructor(
        streamId: String? = null,
        videoSource: VideoSource,
        audioSource: AudioSource,
        fromUser: User
) : Stream(
        streamId,
        videoSource,
        audioSource,
        fromUser
)

class RemoteStream internal constructor(
        override val streamId: String,
        videoSource: VideoSource,
        audioSource: AudioSource,
        fromUser: User
) : Stream(
        videoSource = videoSource,
        audioSource = audioSource,
        fromUser = fromUser
)
