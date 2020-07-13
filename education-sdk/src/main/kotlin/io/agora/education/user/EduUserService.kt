package io.agora.education.user

import android.view.View
import io.agora.education.edumanager.bean.EduStream
import io.agora.education.edumanager.bean.EduTextMessage
import io.agora.education.edumanager.bean.EduUser
import io.agora.education.user.bean.EduRenderConfig
import io.agora.education.user.bean.EduStreamConfig
import io.agora.education.user.bean.EduSubscribeOptions
import io.agora.education.user.bean.EduVideoConfig

abstract class EduUserService constructor() {
    lateinit var eduVideoConfig: EduVideoConfig

    /**media*/
    abstract fun startOrUpdateLocalStream(streamConfig: EduStreamConfig,
                                          successCallback: (stream: EduStream) -> Unit,
                                          failureCallback: (throwable: Throwable) -> Unit): Void
    abstract fun switchCamera(): Void

    /**stream*/
    abstract fun subscribeStream(stream: EduStream, options: EduSubscribeOptions): Void
    abstract fun unsubscribeStream(stream: EduStream, options: EduSubscribeOptions): Void

    abstract fun publishStream(stream: EduStream)
    abstract fun unpublishStream(stream: EduStream)

    /**message*/
    abstract fun sendRoomMessage(text: String, successCallback: (textMessage: EduTextMessage) -> Unit,
                                 failureCallback: (throwable: Throwable) -> Unit): Void
    abstract fun sendUserMessage(text: String, remoteUser: EduUser,
                                 successCallback: (textMessage: EduTextMessage) -> Unit,
                                 failureCallback: (throwable: Throwable) -> Unit): Void

    /**render*/
    abstract fun setStreamView(stream: EduStream, view: View): Void
    abstract fun setStreamView(stream: EduStream, view: View, config: EduRenderConfig): Void
}