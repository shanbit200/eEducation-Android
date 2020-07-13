package io.agora.education.edumanager.bean

import io.agora.education.edumanager.enums.EduVideoSourceType

class EduStream constructor() {
    lateinit var streamUuid: String
    lateinit var streamName: String
    lateinit var sourceType: EduVideoSourceType
    var hasVideo: Boolean = false
    var hasAudio: Boolean = false
    lateinit var userInfo: EduUser

    constructor(streamUuid: String, streamName: String, sourceType: EduVideoSourceType, hasVideo: Boolean,
                hasAudio: Boolean, userInfo: EduUser) : this() {
        this.streamUuid = streamUuid
        this.streamName = streamName
        this.sourceType = sourceType
        this.hasVideo = hasVideo
        this.hasAudio = hasAudio
        this.userInfo = userInfo
    }
}