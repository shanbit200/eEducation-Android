package io.agora.education.classroom

import io.agora.base.callback.Callback
import io.agora.education.stream.Stream
import io.agora.education.user.User
import io.agora.education.user.LocalUserService

class ClassroomManagerImpl<T : LocalUserService> : ClassroomManager<T>() {
    override fun getOnlineUserCount(callback: Callback<Int>) {
        TODO("Not yet implemented")
    }

    override fun getOnlineUserList(fromIndex: Int, toIndex: Int, callback: Callback<List<User>>) {
        TODO("Not yet implemented")
    }

    override fun getStreamList(callback: Callback<List<Stream>>) {
        TODO("Not yet implemented")
    }

    override fun joinRoom(params: JoinRoomParams, callback: Callback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun leaveRoom(callback: Callback<Unit>) {
        TODO("Not yet implemented")
    }
}