package io.agora.education.classroom

import io.agora.base.callback.Callback
import io.agora.education.stream.Stream
import io.agora.education.user.User
import io.agora.education.user.LocalUserService

abstract class ClassroomManager<T : LocalUserService> {
    lateinit var classroom: Classroom
        protected set
    lateinit var localUserService: T
        protected set
    var eventHandler: ClassroomEventHandler? = null

    abstract fun getOnlineUserCount(callback: Callback<Int>)

    abstract fun getOnlineUserList(fromIndex: Int, toIndex: Int, callback: Callback<List<User>>)

    abstract fun getStreamList(callback: Callback<List<Stream>>)

    abstract fun joinRoom(params: JoinRoomParams, callback: Callback<Unit>)

    abstract fun leaveRoom(callback: Callback<Unit>)
}
