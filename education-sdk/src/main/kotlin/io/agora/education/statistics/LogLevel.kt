package io.agora.education.statistics

enum class LogLevel(var level:Int) {
    LOG_LEVEL_NONE(0x0000),
    LOG_LEVEL_INFO(0x0001),
    LOG_LEVEL_WARN(0x0002),
    LOG_LEVEL_ERROR(0x0004),
}