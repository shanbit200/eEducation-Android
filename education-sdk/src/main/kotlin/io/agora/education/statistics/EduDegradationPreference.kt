package io.agora.education.statistics

enum class EduDegradationPreference(value: Int) {
    /** (Default) Degrades the frame rate to guarantee the video quality. */
    EduDegradationMaintainQuality  (0),
    /** Degrades the video quality to guarantee the frame rate. */
    EduDegradationMaintainFramerate(1),
    /** Reserved for future use. */
    EduDegradationBalanced         (2)
}