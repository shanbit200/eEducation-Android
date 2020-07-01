package io.agora.education

import io.agora.base.callback.Callback
import io.agora.education.classroom.ClassroomManager
import io.agora.education.classroom.CreateRoomConfig
import io.agora.education.classroom.CreateRoomParams
import io.agora.education.user.LocalUserService
import java.util.logging.Level

internal class EduManagerImpl(
        appId: String,
        authorization: String
) : EduManager(appId, authorization) {
    override fun <T : LocalUserService> createClassroom(params: CreateRoomParams, config: CreateRoomConfig, callback: Callback<ClassroomManager<T>>) {
        TODO("Not yet implemented")
    }

    override fun enableDebugMode(enable: Boolean) {
        TODO("Not yet implemented")
    }

    override fun log(logLevel: Level, log: String) {
        TODO("Not yet implemented")
    }

    override fun uploadLog(callback: Callback<String>) {
        TODO("Not yet implemented")
    }
}
