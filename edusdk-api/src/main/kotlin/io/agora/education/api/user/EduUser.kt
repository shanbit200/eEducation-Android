package io.agora.education.api.user

import android.view.View
import io.agora.education.api.EduCallback
import io.agora.education.api.message.EduTextMessage
import io.agora.education.api.stream.data.*
import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.api.user.listener.EduUserEventListener

interface EduUser {
    var videoEncoderConfig: VideoEncoderConfig

    var eventListener: EduUserEventListener?

    fun initOrUpdateLocalStream(options: LocalStreamInitOptions, callback: EduCallback<EduStreamInfo>)

    fun switchCamera()

    fun subscribeStream(stream: EduStreamInfo, options: StreamSubscribeOptions)

    fun unSubscribeStream(stream: EduStreamInfo)

    fun publishStream(stream: EduStreamInfo)

    fun unPublishStream(stream: EduStreamInfo)

    fun sendRoomMessage(message: String, callback: EduCallback<EduTextMessage>)

    fun sendUserMessage(message: String, user: EduUserInfo, callback: EduCallback<EduTextMessage>)

    fun setStreamView(stream: EduStreamInfo, view: View, config: VideoRenderConfig = VideoRenderConfig())
}
