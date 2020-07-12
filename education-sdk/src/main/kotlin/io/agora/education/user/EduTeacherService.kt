package io.agora.education.user

import io.agora.education.edumanager.EduStream
import io.agora.education.edumanager.EduUser
import io.agora.education.statistics.EduCourseState

abstract class EduTeacherService constructor() : EduUserService() {
    abstract fun updateCourseState(courseState: EduCourseState, successCallback: () -> Unit,
                                   failureCallback: (throwable: Throwable) -> Unit)

    /**chat*/
    abstract fun allowStudentChat(enable: Boolean, successCallback: () -> Unit,
                                  failureCallback: (throwable: Throwable) -> Unit)

    abstract fun allowRemoteStudentChat(enable: Boolean, remoteUser: EduUser,
                                        successCallback: () -> Unit,
                                        failureCallback: (throwable: Throwable) -> Unit)

    abstract fun startShareScreen(screenConfig: EduShareScreenConfig,
                                  successCallback: (stream: EduStream) -> Unit,
                                  failureCallback: (throwable: Throwable) -> Unit)

    abstract fun stopShareScreen(successCallback: (stream: EduStream) -> Unit,
                                 failureCallback: (throwable: Throwable) -> Unit)

    abstract fun remoteStartStudentCamera(remoteStream: EduStream,
                                          successCallback: (stream: EduStream) -> Unit,
                                          failureCallback: (throwable: Throwable) -> Unit)

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