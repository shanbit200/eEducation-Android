package io.agora.education.media

import io.agora.education.media.audio.AudioSource
import io.agora.education.media.video.VideoSource
import io.agora.education.user.User

open class MediaStream internal constructor(
        val streamId: Int,
        val videoSource: VideoSource? = null,
        val audioSource: AudioSource? = null
)

open class LocalMediaStream(
        videoSource: VideoSource?,
        audioSource: AudioSource?
) : MediaStream(
        0,
        videoSource,
        audioSource
)

class RemoteMediaStream internal constructor(
        streamId: Int,
        videoSource: VideoSource,
        audioSource: AudioSource,
        val publisher: User
) : MediaStream(
        streamId,
        videoSource = videoSource,
        audioSource = audioSource
)
