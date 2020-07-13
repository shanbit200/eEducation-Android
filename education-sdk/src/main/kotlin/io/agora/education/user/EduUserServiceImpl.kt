package io.agora.education.user

import android.view.View
import io.agora.education.edumanager.bean.EduStream
import io.agora.education.edumanager.bean.EduTextMessage
import io.agora.education.edumanager.bean.EduUser
import io.agora.education.user.bean.EduRenderConfig
import io.agora.education.user.bean.EduStreamConfig
import io.agora.education.user.bean.EduSubscribeOptions

class EduUserServiceImpl constructor() : EduUserService() {

    override fun startOrUpdateLocalStream(streamConfig: EduStreamConfig, successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun switchCamera(): Void {
        TODO("Not yet implemented")
    }

    override fun subscribeStream(stream: EduStream, options: EduSubscribeOptions): Void {
        TODO("Not yet implemented")
    }

    override fun unsubscribeStream(stream: EduStream, options: EduSubscribeOptions): Void {
        TODO("Not yet implemented")
    }

    override fun publishStream(stream: EduStream) {
        TODO("Not yet implemented")
    }

    override fun unpublishStream(stream: EduStream) {
        TODO("Not yet implemented")
    }

    override fun sendRoomMessage(text: String, successCallback: (textMessage: EduTextMessage) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun sendUserMessage(text: String, remoteUser: EduUser, successCallback: (textMessage: EduTextMessage) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun setStreamView(stream: EduStream, view: View): Void {
        TODO("Not yet implemented")
    }

    override fun setStreamView(stream: EduStream, view: View, config: EduRenderConfig): Void {
        TODO("Not yet implemented")
    }
}