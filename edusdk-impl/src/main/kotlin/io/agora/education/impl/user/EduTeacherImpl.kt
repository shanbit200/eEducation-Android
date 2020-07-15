package io.agora.education.impl.user

import io.agora.education.api.EduCallback
import io.agora.education.api.room.data.EduRoomState
import io.agora.education.api.stream.data.ScreenStreamInitOptions
import io.agora.education.api.stream.data.EduStreamInfo
import io.agora.education.api.user.EduTeacher
import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.api.user.listener.EduTeacherEventListener

internal class EduTeacherImpl : EduUserImpl(), EduTeacher {
    override fun setEventListener(eventListener: EduTeacherEventListener) {
        this.eventListener = eventListener
    }

    override fun beginClass(callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun endClass(callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun allowStudentChat(enable: Boolean, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun allowStudentChat(enable: Boolean, student: EduUserInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun startShareScreen(options: ScreenStreamInitOptions, callback: EduCallback<EduStreamInfo>) {
        TODO("Not yet implemented")
    }

    override fun stopShareScreen(callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun openStudentCamera(stream: EduStreamInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun closeStudentCamera(stream: EduStreamInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun openStudentMicrophone(stream: EduStreamInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun closeStudentMicrophone(stream: EduStreamInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }
}
