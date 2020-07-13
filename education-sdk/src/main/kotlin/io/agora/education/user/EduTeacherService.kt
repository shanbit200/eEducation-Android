package io.agora.education.user

import io.agora.education.edumanager.bean.EduStream
import io.agora.education.edumanager.bean.EduUser
import io.agora.education.room.enums.EduCourseState
import io.agora.education.user.bean.EduShareScreenConfig

abstract class EduTeacherService constructor() : EduUserService() {
    /**更新课程状态*/
    abstract fun updateCourseState(courseState: EduCourseState, successCallback: () -> Unit,
                                   failureCallback: (throwable: Throwable) -> Unit)

    /**是否允许所有学生聊天(即群聊开关)*/
    abstract fun allowStudentChat(enable: Boolean, successCallback: () -> Unit,
                                  failureCallback: (throwable: Throwable) -> Unit)

    /**是否允许某一学生聊天(即远端学生的聊天开关)*/
    abstract fun allowRemoteStudentChat(enable: Boolean, remoteUser: EduUser,
                                        successCallback: () -> Unit,
                                        failureCallback: (throwable: Throwable) -> Unit)

    abstract fun startShareScreen(screenConfig: EduShareScreenConfig,
                                  successCallback: (stream: EduStream) -> Unit,
                                  failureCallback: (throwable: Throwable) -> Unit)

    abstract fun stopShareScreen(successCallback: (stream: EduStream) -> Unit,
                                 failureCallback: (throwable: Throwable) -> Unit)

    /**订阅remoteStream，并通过服务器通知(RTM)到对应的Student打开自己本地摄像头并进行推流*/
    abstract fun remoteStartStudentCamera(remoteStream: EduStream,
                                          successCallback: (stream: EduStream) -> Unit,
                                          failureCallback: (throwable: Throwable) -> Unit)

    /**取消对remoteStream的订阅，并通过服务器通知(RTM)到对应的Student关闭(mute)自己本地摄像头并
     * 停止推流*/
    abstract fun remoteStopStudentCamera(remoteStream: EduStream,
                                         successCallback: (stream: EduStream) -> Unit,
                                         failureCallback: (throwable: Throwable) -> Unit)

    abstract fun remoteStartStudentMicrophone(remoteStream: EduStream,
                                              successCallback: (stream: EduStream) -> Unit,
                                              failureCallback: (throwable: Throwable) -> Unit)

    abstract fun remoteStopStudentMicrophone(remoteStream: EduStream,
                                             successCallback: (stream: EduStream) -> Unit,
                                             failureCallback: (throwable: Throwable) -> Unit)
}