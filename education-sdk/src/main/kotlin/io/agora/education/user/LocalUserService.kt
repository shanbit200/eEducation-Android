package io.agora.education.user

import android.view.ViewGroup
import io.agora.education.stream.LocalStream
import io.agora.education.stream.RemoteStream
import io.agora.education.stream.Stream
import io.agora.education.stream.SubscribeOption
import io.agora.education.stream.video.VideoRenderConfig

interface LocalUserService {
    val localUser: User
    val defaultLocalStream: LocalStream

    fun subscribe(stream: RemoteStream, option: SubscribeOption)

    fun unSubscribe(stream: RemoteStream, option: SubscribeOption)

    fun publish(stream: LocalStream)

    fun unPublish(stream: LocalStream)

    fun sendRoomMessage(message: String)

    fun sendPeerMessage(message: String, user: User)

    fun setView(container: ViewGroup, stream: Stream, config: VideoRenderConfig)
}
