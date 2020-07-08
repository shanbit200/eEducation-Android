package io.agora.education.impl

import android.view.ViewGroup
import io.agora.education.media.LocalMediaStream
import io.agora.education.media.MediaStream
import io.agora.education.media.RemoteMediaStream
import io.agora.education.media.SubscribeOption
import io.agora.education.media.video.VideoRenderConfig
import io.agora.education.user.LocalUserEventHandler
import io.agora.education.user.LocalUserService
import io.agora.education.user.User

open class LocalUserServiceImpl internal constructor(
        override val localUser: User
) : LocalUserService {
    override val localMediaStreams: MutableList<LocalMediaStream> by lazy {
        mutableListOf<LocalMediaStream>()
    }
    override var eventHandler: LocalUserEventHandler? = null

    override fun subscribe(stream: RemoteMediaStream, option: SubscribeOption) {
        TODO("Not yet implemented")
    }

    override fun unSubscribe(stream: RemoteMediaStream, option: SubscribeOption) {
        TODO("Not yet implemented")
    }

    override fun publish(stream: LocalMediaStream) {
        localMediaStreams.add(stream)
        TODO("Not yet implemented")
    }

    override fun unPublish(stream: LocalMediaStream) {
        localMediaStreams.remove(stream)
        TODO("Not yet implemented")
    }

    override fun sendRoomMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun sendPeerMessage(message: String, user: User) {
        TODO("Not yet implemented")
    }

    override fun setView(container: ViewGroup?, mediaStream: MediaStream, config: VideoRenderConfig) {
        TODO("Not yet implemented")
    }
}
