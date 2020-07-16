package io.agora.education.impl.user

import android.view.View
import io.agora.education.api.EduCallback
import io.agora.education.api.message.EduTextMessage
import io.agora.education.api.stream.data.*
import io.agora.education.api.user.EduUser
import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.api.user.listener.EduUserEventListener

internal open class EduUserImpl(
        override var userInfo: EduUserInfo
) : EduUser {
    override var videoEncoderConfig: VideoEncoderConfig = VideoEncoderConfig()

    override var eventListener: EduUserEventListener? = null

    override fun initOrUpdateLocalStream(options: LocalStreamInitOptions, callback: EduCallback<EduStreamInfo>) {
        TODO("Not yet implemented")
    }

    override fun switchCamera() {
        TODO("Not yet implemented")
    }

    override fun subscribeStream(stream: EduStreamInfo, options: StreamSubscribeOptions) {
        TODO("Not yet implemented")
    }

    override fun unSubscribeStream(stream: EduStreamInfo) {
        TODO("Not yet implemented")
    }

    override fun publishStream(stream: EduStreamInfo) {
        TODO("Not yet implemented")
    }

    override fun unPublishStream(stream: EduStreamInfo) {
        TODO("Not yet implemented")
    }

    override fun sendRoomMessage(message: String, callback: EduCallback<EduTextMessage>) {
        TODO("Not yet implemented")
    }

    override fun sendUserMessage(message: String, user: EduUserInfo, callback: EduCallback<EduTextMessage>) {
        TODO("Not yet implemented")
    }

    override fun setStreamView(stream: EduStreamInfo, view: View, config: VideoRenderConfig) {
        TODO("Not yet implemented")
    }
}
