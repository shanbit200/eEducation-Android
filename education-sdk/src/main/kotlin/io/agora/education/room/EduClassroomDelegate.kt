package io.agora.education.room

import io.agora.education.edumanager.EduStream
import io.agora.education.edumanager.EduTextMessage
import io.agora.education.edumanager.EduUser
import io.agora.education.statistics.ConnectionState
import io.agora.education.statistics.EduClassroomStateType
import io.agora.education.statistics.NetworkQuality

interface EduClassroomDelegate {
    /**user in or out*/
    fun onRemoteUsersInitJoined(stream: EduStream, count: Int, fromClassRoom: EduClassroom): Void

    fun onRemoteUsersJoined(user: EduUser, count: Int, fromClassRoom: EduClassroom): Void

    fun onRemoteUsersLeft(user: EduUser, count: Int, fromClassRoom: EduClassroom): Void

    /**message*/
    fun onRoomMessageReceived(textMessage: EduTextMessage, fromClassRoom: EduClassroom): Void

    fun onUserMessageReceived(textMessage: EduTextMessage, fromClassRoom: EduClassroom): Void

    /**stream*/
    fun onRemoteStreamsInitAdded(stream: EduStream, count: Int, fromClassRoom: EduClassroom): Void

    fun onRemoteStreamsAdded(stream: EduStream, count: Int, fromClassRoom: EduClassroom): Void

    fun onRemoteStreamsUpdated(stream: EduStream, count: Int, fromClassRoom: EduClassroom): Void

    fun onRemoteStreamsRemoved(stream: EduStream, count: Int, fromClassRoom: EduClassroom): Void

    /**class room*/
    fun onUpdateClassroom(stateType: EduClassroomStateType, fromClassRoom: EduClassroom): Void

    /**state*/
    fun onConnectionStateChanged(state: ConnectionState, reason: ConnectionState, fromClassRoom: EduClassroom): Void
    fun onNetworkQualityChanged(quality: NetworkQuality, user: EduUser, fromClassRoom: EduClassroom): Void
}