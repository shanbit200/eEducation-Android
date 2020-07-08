package io.agora.education.media.video

import io.agora.education.media.MediaPublishState

class CameraVideoSource : VideoSource(VideoSourceType.CAMERA) {
    fun openCamera(): CameraVideoSource {
        state = MediaPublishState.IDLE
        return this
    }

    fun closeCamera(): CameraVideoSource {
        state = MediaPublishState.NO_PUBLISH
        return this
    }
}
