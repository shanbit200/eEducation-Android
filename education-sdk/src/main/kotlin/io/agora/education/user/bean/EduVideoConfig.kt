package io.agora.education.user.bean

import io.agora.education.user.enums.EduDegradationPreference
import io.agora.education.user.enums.EduVideoOutputOrientationMode

class EduVideoConfig constructor() {
    var videoDimensionWidth:Int = 360
    var videoDimensionHeight: Int = 360
    var fps: Int = 15
    var orientationMode: EduVideoOutputOrientationMode = EduVideoOutputOrientationMode.EduVideoOutputOrientationModeFixedLandscape
    var degradationPreference: EduDegradationPreference = EduDegradationPreference.EduDegradationMaintainQuality

    constructor(videoDimensionWidth:Int, videoDimensionHeight: Int, fps: Int,
                orientationMode: EduVideoOutputOrientationMode,
                degradationPreference: EduDegradationPreference): this() {
        this.videoDimensionWidth = videoDimensionWidth
        this.videoDimensionHeight = videoDimensionHeight
        this.fps = fps
        this.orientationMode = orientationMode
        this.degradationPreference = degradationPreference
    }
}