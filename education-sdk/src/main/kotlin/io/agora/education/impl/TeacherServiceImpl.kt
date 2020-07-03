package io.agora.education.impl

import io.agora.education.classroom.CourseState
import io.agora.education.media.LocalMediaStream
import io.agora.education.media.MediaPublishState
import io.agora.education.media.RemoteMediaStream
import io.agora.education.media.video.ScreenVideoSource
import io.agora.education.user.TeacherService
import io.agora.education.user.User

class TeacherServiceImpl internal constructor(
        localUser: User
) : LocalUserServiceImpl(localUser), TeacherService {
    override fun updateCourseState(state: CourseState) {
        TODO("Not yet implemented")
    }

    override fun forbiddenRoomMessage(isForbidden: Boolean) {
        TODO("Not yet implemented")
    }

    override fun forbiddenRoomMessage(user: User, isForbidden: Boolean) {
        TODO("Not yet implemented")
    }

    override fun startShareScreen(): LocalMediaStream {
        val stream = LocalMediaStream(ScreenVideoSource(), null)
        publish(stream)
        return stream
    }

    override fun controlRemoteVideoStream(stream: RemoteMediaStream, enable: Boolean) {
        stream.videoSource?.state = if (enable) MediaPublishState.PUBLISHED else MediaPublishState.NO_PUBLISH
    }

    override fun controlRemoteAudioStream(stream: RemoteMediaStream, enable: Boolean) {
        stream.audioSource?.state = if (enable) MediaPublishState.PUBLISHED else MediaPublishState.NO_PUBLISH
    }
}
