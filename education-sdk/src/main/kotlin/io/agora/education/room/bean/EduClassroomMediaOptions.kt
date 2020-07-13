package io.agora.education.room.bean

class EduClassroomMediaOptions constructor() {
    /**自动拉视频流*/
    var autoSubscribeVideo: Boolean = true
    /**自动拉音频流*/
    var autoSubscribeAudio: Boolean = true
    /**自动开启照相机推流*/
    var autoPublishCamera: Boolean = true
    /**自动开启麦克风推流*/
    var autoPublishMicrophone: Boolean = true

    constructor(autoSubscribeVideo: Boolean, autoSubscribeAudio: Boolean, autoPublishCamera: Boolean,
                autoPublishMicrophone: Boolean): this() {

    }
}