package io.agora.education.user

import io.agora.education.media.LocalMediaStream
import io.agora.education.message.TextMessage
import io.agora.education.statistics.ConnectionState

interface LocalUserEventHandler {
    fun onConnectionStateChanged(state: ConnectionState)

    fun onLocalMediaStreamStateUpdated(stream: LocalMediaStream, byUser: User)

    fun onReceivedPeerMessage(message: TextMessage)
}
