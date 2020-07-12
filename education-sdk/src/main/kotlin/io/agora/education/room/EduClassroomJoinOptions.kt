package io.agora.education.room

import io.agora.education.statistics.EduRoleType

class EduClassroomJoinOptions constructor() {
    lateinit var userName: String
    lateinit var userUuid: String
    lateinit var mediaOptions: EduClassroomMediaOptions

    constructor(userName: String, userUuid: String) : this() {
        this.userName = userName
        this.userUuid = userUuid
        this.mediaOptions = EduClassroomMediaOptions(autoSubscribeVideo = true, autoSubscribeAudio = true,
                autoPublishCamera = true, autoPublishMicrophone = true)
    }

    constructor(userName: String, userUuid: String, mediaOptions: EduClassroomMediaOptions): this() {
        this.userName = userName
        this.userUuid = userUuid
        this.mediaOptions = mediaOptions
    }
}