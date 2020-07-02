package io.agora.education.impl

import android.view.ViewGroup
import io.agora.education.stream.LocalStream
import io.agora.education.stream.RemoteStream
import io.agora.education.stream.Stream
import io.agora.education.stream.SubscribeOption
import io.agora.education.stream.audio.AudioSource
import io.agora.education.stream.audio.AudioSourceType
import io.agora.education.stream.video.VideoRenderConfig
import io.agora.education.stream.video.VideoSource
import io.agora.education.stream.video.VideoSourceType
import io.agora.education.user.LocalUserService
import io.agora.education.user.User

open class LocalUserServiceImpl internal constructor(
        override val localUser: User
) : LocalUserService {
    override val defaultLocalStream: LocalStream by lazy {
        LocalStream(
                videoSource = VideoSource(VideoSourceType.CAMERA, true),
                audioSource = AudioSource(AudioSourceType.MICROPHONE, true),
                fromUser = localUser
        )
    }

    override fun subscribe(stream: RemoteStream, option: SubscribeOption) {
        TODO("Not yet implemented")
    }

    override fun unSubscribe(stream: RemoteStream, option: SubscribeOption) {
        TODO("Not yet implemented")
    }

    override fun publish(stream: LocalStream) {
        TODO("Not yet implemented")
    }

    override fun unPublish(stream: LocalStream) {
        TODO("Not yet implemented")
    }

    override fun sendRoomMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun sendPeerMessage(message: String, user: User) {
        TODO("Not yet implemented")
    }

    override fun setView(container: ViewGroup, stream: Stream, config: VideoRenderConfig) {
        TODO("Not yet implemented")
    }
}
