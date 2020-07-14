package io.agora.education.user

import android.content.Context
import android.text.TextUtils
import android.view.View
import io.agora.base.callback.Callback
import io.agora.base.callback.ThrowableCallback
import io.agora.base.network.RetrofitManager
import io.agora.education.edumanager.bean.EduStream
import io.agora.education.edumanager.bean.EduTextMessage
import io.agora.education.edumanager.bean.EduUser
import io.agora.education.user.bean.EduRenderConfig
import io.agora.education.user.bean.EduStreamConfig
import io.agora.education.user.bean.EduSubscribeOptions
import io.agora.education.user.bean.request.EduUserMsgReq
import io.agora.education.user.bean.response.ResponseBody
import io.agora.education.user.network.UserClient
import io.agora.log.UploadManager
import io.agora.log.UploadManager.UploadParam
import io.agora.log.service.LogService
import io.agora.log.service.bean.response.LogParamsRes

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

    override fun sendUserMessage(text: String, remoteUser: EduUser,
                                 successCallback: (textMessage: EduTextMessage) -> Unit,
                                 failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun setStreamView(stream: EduStream, view: View): Void {
        TODO("Not yet implemented")
    }

    override fun setStreamView(stream: EduStream, view: View, config: EduRenderConfig): Void {
        TODO("Not yet implemented")
    }
}