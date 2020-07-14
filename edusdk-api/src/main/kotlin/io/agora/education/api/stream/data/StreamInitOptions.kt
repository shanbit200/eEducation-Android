package io.agora.education.api.stream.data

open class StreamInitOptions(
        var streamUuid: String,
        var streamName: String
)

class LocalStreamInitOptions(
        streamUuid: String,
        streamName: String,
        var enableCamera: Boolean = true,
        var enableMicrophone: Boolean = true
) : StreamInitOptions(streamUuid, streamName)

class ScreenStreamInitOptions(
        streamUuid: String,
        streamName: String
) : StreamInitOptions(streamUuid, streamName)
