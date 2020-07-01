package io.agora.education.user

import android.view.ViewGroup
import io.agora.education.stream.Stream
import io.agora.education.stream.SubscribeOption
import io.agora.education.stream.audio.AudioSource
import io.agora.education.stream.audio.AudioSourceType
import io.agora.education.stream.video.VideoRenderConfig
import io.agora.education.stream.video.VideoSource
import io.agora.education.stream.video.VideoSourceType

abstract class LocalUserService(
        val localUser: User
) {
    private val localStream: Stream by lazy {
        Stream().apply {
            videoSource = VideoSource().apply {
                type = VideoSourceType.CAMERA
                enable = true
            }
            audioSource = AudioSource().apply {
                type = AudioSourceType.MICROPHONE
                enable = true
            }
            fromUser = localUser
        }
    }

    fun startCamera(): Stream {
        localStream.videoSource.enable = true
        return localStream
    }

    fun stopCamera(): Stream {
        localStream.videoSource.enable = false
        return localStream
    }

    fun startMicrophone(): Stream {
        localStream.audioSource.enable = true
        return localStream
    }

    fun stopMicrophone(): Stream {
        localStream.audioSource.enable = false
        return localStream
    }

    abstract fun subscribe(stream: Stream, option: SubscribeOption)

    abstract fun unSubscribe(stream: Stream, option: SubscribeOption)

    abstract fun publish(stream: Stream)

    abstract fun unPublish(stream: Stream)

    abstract fun sendRoomMessage(message: String)

    abstract fun sendPeerMessage(message: String, user: User)

    abstract fun setView(container: ViewGroup, stream: Stream)

    abstract fun setView(container: ViewGroup, stream: Stream, config: VideoRenderConfig)
}
