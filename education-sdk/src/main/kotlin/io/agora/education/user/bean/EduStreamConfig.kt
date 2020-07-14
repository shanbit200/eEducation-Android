package io.agora.education.user.bean

class EduStreamConfig constructor() {
    lateinit var streamUuid: String
    lateinit var streamName: String
    var enableCamera: Boolean = true
    var enableMicrophone: Boolean = true

    constructor(streamUuid: String, streamName: String) : this() {
        this.streamUuid = streamUuid
        this.streamName = streamName
    }

    constructor(streamUuid: String, streamName: String, enableCamera: Boolean, enableMicrophone: Boolean):
            this() {
        this.streamUuid = streamUuid
        this.streamName = streamName
        this.enableCamera = enableCamera
        this.enableMicrophone = enableMicrophone
    }
}