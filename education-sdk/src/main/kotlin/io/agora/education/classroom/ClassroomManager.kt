package io.agora.education.classroom

import io.agora.base.callback.Callback
import io.agora.education.stream.RemoteStream
import io.agora.education.user.LocalUserService
import io.agora.education.user.User

abstract class ClassroomManager<T : LocalUserService> internal constructor() {
    lateinit var classroom: Classroom
        protected set
    protected lateinit var localUserService: T
    var eventHandler: ClassroomEventHandler? = null

    abstract fun getOnlineUserCount(callback: Callback<Int>)

    abstract fun getOnlineUserList(fromIndex: Int, toIndex: Int, callback: Callback<List<User>>)

    abstract fun getStreamList(callback: Callback<List<RemoteStream>>)

    abstract fun joinRoom(options: JoinOptions, callback: Callback<T>)

    abstract fun leaveRoom(callback: Callback<Unit>)
}
