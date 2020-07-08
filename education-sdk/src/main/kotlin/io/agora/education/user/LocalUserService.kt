package io.agora.education.user

import android.view.ViewGroup
import io.agora.education.media.LocalMediaStream
import io.agora.education.media.MediaStream
import io.agora.education.media.RemoteMediaStream
import io.agora.education.media.SubscribeOption
import io.agora.education.media.video.VideoRenderConfig

interface LocalUserService {
    val localUser: User
    val localMediaStreams: List<LocalMediaStream>
    var eventHandler: LocalUserEventHandler?

    fun subscribe(stream: RemoteMediaStream, option: SubscribeOption)

    fun unSubscribe(stream: RemoteMediaStream, option: SubscribeOption)

    fun publish(stream: LocalMediaStream)

    fun unPublish(stream: LocalMediaStream)

    fun sendRoomMessage(message: String)

    fun sendPeerMessage(message: String, user: User)

    fun setView(container: ViewGroup?, mediaStream: MediaStream, config: VideoRenderConfig)
}
