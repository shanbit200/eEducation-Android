package io.agora.education.user

import android.view.View
import io.agora.education.edumanager.EduStream
import io.agora.education.edumanager.EduTextMessage
import io.agora.education.edumanager.EduUser
import io.agora.education.statistics.EduCourseState

class EduTeacherServiceImpl constructor() : EduTeacherService() {
    override fun updateCourseState(courseState: EduCourseState, successCallback: () -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun allowStudentChat(enable: Boolean, successCallback: () -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun allowRemoteStudentChat(enable: Boolean, remoteUser: EduUser, successCallback: () -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun startShareScreen(screenConfig: EduShareScreenConfig, successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun stopShareScreen(successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun remoteStartStudentCamera(remoteStream: EduStream, successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun remoteStopStudentCamera(remoteStream: EduStream, successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun remoteStartStudentMicrophone(remoteStream: EduStream, successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun remoteStopStudentMicrophone(remoteStream: EduStream, successCallback: (stream: EduStream) -> Unit, failureCallback: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

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