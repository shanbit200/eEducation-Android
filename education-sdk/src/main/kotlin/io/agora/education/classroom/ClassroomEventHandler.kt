package io.agora.education.classroom

import io.agora.education.media.RemoteMediaStream
import io.agora.education.message.TextMessage
import io.agora.education.statistics.NetworkQuality
import io.agora.education.user.User

interface ClassroomEventHandler {
    fun onRoomStatusUpdated(roomStatus: RoomStatus, fromRoom: RoomInfo)

    fun onUserOnline(user: User, fromRoom: RoomInfo)

    fun onUserOffline(user: User, fromRoom: RoomInfo)

    fun onRemoteMediaStreamAdded(stream: RemoteMediaStream, fromRoom: RoomInfo)

    fun onRemoteMediaStreamStateUpdated(stream: RemoteMediaStream, fromRoom: RoomInfo)

    fun onRemoteMediaStreamRemoved(stream: RemoteMediaStream, fromRoom: RoomInfo)

    fun onReceivedRoomMessage(message: TextMessage, fromRoom: RoomInfo)

    fun onUserNetworkQualityChanged(quality: NetworkQuality, user: User, fromRoom: RoomInfo)
}
