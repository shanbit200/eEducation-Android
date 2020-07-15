package io.agora.education.api.room.listener

import io.agora.education.api.message.EduTextMessage
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.RoomStatusEvent
import io.agora.education.api.statistics.ConnectionState
import io.agora.education.api.statistics.ConnectionStateChangeReason
import io.agora.education.api.statistics.NetworkQuality
import io.agora.education.api.stream.data.EduStreamInfo
import io.agora.education.api.user.data.EduUserInfo

interface EduRoomEventListener {
    fun onRemoteUsersInitialized(users: List<EduUserInfo>, fromClassRoom: EduRoom)

    fun onRemoteUsersJoined(users: List<EduUserInfo>, fromClassRoom: EduRoom)

    fun onRemoteUsersLeft(users: List<EduUserInfo>, fromClassRoom: EduRoom)

    fun onRoomMessageReceived(messageEdu: EduTextMessage, fromClassRoom: EduRoom)

    fun onUserMessageReceived(messageEdu: EduTextMessage, fromClassRoom: EduRoom)

    fun onRemoteStreamsInitialized(streams: List<EduStreamInfo>, fromClassRoom: EduRoom)

    fun onRemoteStreamsAdded(streams: List<EduStreamInfo>, fromClassRoom: EduRoom)

    fun onRemoteStreamsUpdated(streams: List<EduStreamInfo>, fromClassRoom: EduRoom)

    fun onRemoteStreamsRemoved(streams: List<EduStreamInfo>, fromClassRoom: EduRoom)

    fun onRoomStatusChanged(event: RoomStatusEvent, fromClassRoom: EduRoom)

    fun onConnectionStateChanged(state: ConnectionState, reason: ConnectionStateChangeReason, fromClassRoom: EduRoom)

    fun onNetworkQualityChanged(quality: NetworkQuality, user: EduUserInfo, fromClassRoom: EduRoom)
}
