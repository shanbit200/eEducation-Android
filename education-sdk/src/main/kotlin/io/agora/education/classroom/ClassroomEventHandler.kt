package io.agora.education.classroom

import io.agora.education.message.TextMessage
import io.agora.education.stream.Stream
import io.agora.education.user.NetworkQuality
import io.agora.education.user.User

interface ClassroomEventHandler {
    fun onUserOnline(user: User, fromRoom: Classroom)

    fun onUserOffline(user: User, fromRoom: Classroom)

    fun onStreamAdded(stream: Stream, fromRoom: Classroom)

    fun onStreamRemoved(stream: Stream, fromRoom: Classroom)

    fun onReceivedRoomMessage(message: TextMessage, fromRoom: Classroom)

    fun onReceivedPeerMessage(message: TextMessage, fromRoom: Classroom)

    fun onRoomStatusUpdated(classroom: Classroom)

    fun onConnectionStateChanged(state: ConnectionState, fromRoom: Classroom)

    fun onNetworkQualityChanged(quality: NetworkQuality, user: User, fromRoom: Classroom)
}