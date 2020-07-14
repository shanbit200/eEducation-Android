package io.agora.education.api.logger

enum class LogLevel(val value: Int) {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ALL(Int.MIN_VALUE),
    NONE(Int.MAX_VALUE),
}
