package io.agora.education.api.user

import android.view.View
import io.agora.education.api.EduCallback
import io.agora.education.api.message.TextMessage
import io.agora.education.api.stream.data.*
import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.api.user.listener.EduUserEventListener

interface EduUser {
    var userInfo: EduUserInfo
    var eventListener: EduUserEventListener?
    var videoEncoderConfig: VideoEncoderConfig

    fun initOrUpdateLocalStream(options: LocalStreamInitOptions, callback: EduCallback<EduStreamInfo>)

    fun switchCamera()

    fun subscribeStream(stream: EduStreamInfo, options: StreamSubscribeOptions)

    fun unSubscribeStream(stream: EduStreamInfo)

    fun publishStream(stream: EduStreamInfo)

    fun unPublishStream(stream: EduStreamInfo)

    fun sendRoomMessage(message: String, callback: EduCallback<TextMessage>)

    fun sendUserMessage(message: String, toRemoteUserInfo: EduUserInfo, callback: EduCallback<TextMessage>)

    fun setStreamView(stream: EduStreamInfo, view: View, config: VideoRenderConfig = VideoRenderConfig())
}
