package io.agora.education.user

import io.agora.education.statistics.EduDegradationPreference
import io.agora.education.statistics.EduVideoOutputOrientationMode

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