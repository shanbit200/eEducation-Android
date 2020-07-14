package io.agora.education.api.user

import io.agora.education.api.EduCallback
import io.agora.education.api.stream.data.EduStreamInfo
import io.agora.education.api.stream.data.ScreenStreamInitOptions
import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.api.user.listener.EduTeacherEventListener

interface EduTeacher : EduUser {
    fun setEventListener(eventListener: EduTeacherEventListener)

    fun beginClass(callback: EduCallback<Unit>)

    fun endClass(callback: EduCallback<Unit>)

    fun allowStudentChat(isAllow: Boolean, callback: EduCallback<Unit>)

    fun allowStudentChat(isAllow: Boolean, user: EduUserInfo, callback: EduCallback<Unit>)

    fun startShareScreen(options: ScreenStreamInitOptions, callback: EduCallback<EduStreamInfo>)

    fun stopShareScreen(callback: EduCallback<Unit>)

    fun openStudentCamera(stream: EduStreamInfo, callback: EduCallback<Unit>)

    fun closeStudentCamera(stream: EduStreamInfo, callback: EduCallback<Unit>)

    fun openStudentMicrophone(stream: EduStreamInfo, callback: EduCallback<Unit>)

    fun closeStudentMicrophone(stream: EduStreamInfo, callback: EduCallback<Unit>)
}
