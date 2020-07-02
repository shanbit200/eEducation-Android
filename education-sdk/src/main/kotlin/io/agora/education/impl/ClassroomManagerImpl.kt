package io.agora.education.impl

import io.agora.base.callback.Callback
import io.agora.education.classroom.ClassroomManager
import io.agora.education.classroom.JoinOptions
import io.agora.education.stream.RemoteStream
import io.agora.education.user.*

class ClassroomManagerImpl<T : LocalUserService> internal constructor() : ClassroomManager<T>() {
    override fun getOnlineUserCount(callback: Callback<Int>) {
        TODO("Not yet implemented")
    }

    override fun getOnlineUserList(fromIndex: Int, toIndex: Int, callback: Callback<List<User>>) {
        TODO("Not yet implemented")
    }

    override fun getStreamList(callback: Callback<List<RemoteStream>>) {
        TODO("Not yet implemented")
    }

    override fun joinRoom(options: JoinOptions, callback: Callback<T>) {
//        TODO("Not yet implemented")
        val user = User("", "", options.role, "")
        localUserService = when (options.role) {
            UserRole.STUDENT -> StudentServiceImpl(user) as T
            UserRole.TEACHER -> TeacherServiceImpl(user) as T
        }
    }

    override fun leaveRoom(callback: Callback<Unit>) {
        TODO("Not yet implemented")
    }
}
