package io.agora.education.user.enums

enum class EduRenderMode(mode: Int) {
    /** Hidden(1): Uniformly scale the video until it fills the visible boundaries (cropped).
     * One dimension of the video may have clipped contents. */
    EduRenderModeHidden(1),
    /** Fit(2): Uniformly scale the video until one of its dimension fits the boundary
     * (zoomed to fit). Areas that are not filled due to the disparity in the aspect ratio are
     * filled with black. */
    EduRenderModeFit   (2)
}