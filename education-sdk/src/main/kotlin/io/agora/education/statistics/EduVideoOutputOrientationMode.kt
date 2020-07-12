package io.agora.education.statistics

enum class EduVideoOutputOrientationMode {
    /** Adaptive mode (Default).
    <p>The video encoder adapts to the orientation mode of the video input device. When you use a custom video source, the output video from the encoder inherits the orientation of the original video.
    <ul><li>If the width of the captured video from the SDK is greater than the height, the encoder sends the video in landscape mode. The encoder also sends the rotational information of the video, and the receiver uses the rotational information to rotate the received video.</li>
    <li>If the original video is in portrait mode, the output video from the encoder is also in portrait mode. The encoder also sends the rotational information of the video to the receiver.</li></ul></p>
     */
    EduVideoOutputOrientationModeAdaptative,
    /** Landscape mode.
    <p>The video encoder always sends the video in landscape mode. The video encoder rotates the original video before sending it and the rotational information is 0. This mode applies to scenarios involving CDN live streaming.</p>
     */
    EduVideoOutputOrientationModeFixedLandscape,
    /** Portrait mode.
    <p>The video encoder always sends the video in portrait mode. The video encoder rotates the original video before sending it and the rotational information is 0. This mode applies to scenarios involving CDN live streaming.</p>
     */
    EduVideoOutputOrientationModeFixedPortrait
}