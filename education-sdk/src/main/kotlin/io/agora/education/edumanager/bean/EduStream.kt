package io.agora.education.edumanager.bean

import io.agora.education.edumanager.enums.EduAudioSourceType
import io.agora.education.edumanager.enums.EduVideoSourceType

class EduStream constructor() {
    /**流id*/
    private lateinit var streamId: String
    /**同一appId下流的唯一id，rtc中uid*/
    lateinit var streamUuid: String
    /**流显示的名字*/
    lateinit var streamName: String
    /**视频源类型 1.camera 2.screen*/
    lateinit var videoSourceType: EduVideoSourceType
    /**音频源类型 1.mic*/
    lateinit var audioSourceType: EduAudioSourceType
    var hasVideo: Boolean = false
    var hasAudio: Boolean = false
    /**1发布 0不发布*/
    var isPublish: Boolean = false
    lateinit var userInfo: EduUser

    constructor(streamId: String, streamUuid: String, streamName: String,
                videoSourceType: EduVideoSourceType,
                audioSourceType: EduAudioSourceType,
                hasVideo: Boolean, hasAudio: Boolean,
                isPublish: Boolean, userInfo: EduUser) : this() {
        this.streamId = streamId
        this.streamUuid = streamUuid
        this.streamName = streamName
        this.videoSourceType = videoSourceType
        this.audioSourceType = audioSourceType
        this.hasVideo = hasVideo
        this.hasAudio = hasAudio
        this.isPublish = isPublish
        this.userInfo = userInfo
    }
}