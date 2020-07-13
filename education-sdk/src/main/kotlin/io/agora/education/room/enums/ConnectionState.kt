package io.agora.education.room.enums

enum class ConnectionState(state: Int) {
    ConnectionStateDisconnected(1),
    ConnectionStateConnecting  (2),
    ConnectionStateConnected   (3),
    ConnectionStateReconnecting(4),
    ConnectionStateAborted     (5)
}