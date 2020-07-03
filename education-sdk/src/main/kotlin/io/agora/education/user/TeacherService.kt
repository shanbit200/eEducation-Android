package io.agora.education.user

import io.agora.education.classroom.CourseState
import io.agora.education.media.LocalMediaStream
import io.agora.education.media.RemoteMediaStream

interface TeacherService : LocalUserService {
    fun updateCourseState(state: CourseState)

    fun forbiddenRoomMessage(isForbidden: Boolean)

    fun forbiddenRoomMessage(user: User, isForbidden: Boolean)

    fun startShareScreen(): LocalMediaStream

    fun controlRemoteVideoStream(stream: RemoteMediaStream, enable: Boolean)

    fun controlRemoteAudioStream(stream: RemoteMediaStream, enable: Boolean)
}
