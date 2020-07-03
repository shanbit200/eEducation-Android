package io.agora.education.impl

import io.agora.base.callback.Callback
import io.agora.education.classroom.ClassroomManager
import io.agora.education.classroom.JoinOptions
import io.agora.education.media.RemoteMediaStream
import io.agora.education.user.LocalUserService
import io.agora.education.user.User
import io.agora.education.user.UserRole

class ClassroomManagerImpl<T : LocalUserService> internal constructor() : ClassroomManager<T>() {
    override val remoteMediaStreams: MutableList<RemoteMediaStream> by lazy {
        mutableListOf<RemoteMediaStream>()
    }

    override fun getOnlineUserCount(callback: Callback<Int>) {
        TODO("Not yet implemented")
    }

    override fun getOnlineUserList(fromIndex: Int, toIndex: Int, callback: Callback<List<User>>) {
        TODO("Not yet implemented")
    }

    override fun getRemoteMediaStreamList(callback: Callback<List<RemoteMediaStream>>) {
        TODO("Not yet implemented")
    }

    override fun joinRoom(options: JoinOptions, callback: Callback<T>) {
        val user = User("", "", options.role, "")
        localUserService = when (options.role) {
            UserRole.STUDENT -> StudentServiceImpl(user) as T
            UserRole.TEACHER -> TeacherServiceImpl(user) as T
        }
        TODO("Not yet implemented")
    }

    override fun leaveRoom(callback: Callback<Unit>) {
        TODO("Not yet implemented")
    }
}
