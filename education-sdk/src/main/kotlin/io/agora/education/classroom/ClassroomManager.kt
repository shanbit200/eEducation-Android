package io.agora.education.classroom

import io.agora.base.callback.Callback
import io.agora.education.media.RemoteMediaStream
import io.agora.education.user.LocalUserService
import io.agora.education.user.User

abstract class ClassroomManager<T : LocalUserService> internal constructor() {
    lateinit var classroom: Classroom
        protected set
    var eventHandler: ClassroomEventHandler? = null

    protected lateinit var localUserService: T
    protected abstract val remoteMediaStreams: List<RemoteMediaStream>

    abstract fun getOnlineUserCount(callback: Callback<Int>)

    abstract fun getOnlineUserList(fromIndex: Int, toIndex: Int, callback: Callback<List<User>>)

    abstract fun getRemoteMediaStreamList(callback: Callback<List<RemoteMediaStream>>)

    abstract fun joinRoom(options: JoinOptions, callback: Callback<T>)

    abstract fun leaveRoom(callback: Callback<Unit>)
}
