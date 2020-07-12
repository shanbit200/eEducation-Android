package io.agora.education.statistics

enum class ConnectionChangeReason(reason: Int) {
    ConnectionChangeReasonLogin         (1),
    ConnectionChangeReasonLoginSuccess  (2),
    ConnectionChangeReasonLoginFailure  (3),
    ConnectionChangeReasonLoginTimeout  (4),
    ConnectionChangeReasonInterrupted   (5),
    ConnectionChangeReasonLogout        (6),
    ConnectionChangeReasonBannedByServer(7),
    ConnectionChangeReasonRemoteLogin   (8),
}