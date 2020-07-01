package io.agora.education

import io.agora.base.callback.Callback
import io.agora.education.classroom.ClassroomManager
import io.agora.education.classroom.CreateRoomConfig
import io.agora.education.classroom.CreateRoomParams
import io.agora.education.user.LocalUserService
import java.util.logging.Level

abstract class EduManager(
        protected val appId: String,
        protected val authorization: String
) {
    companion object {
        @JvmStatic
        fun init(appId: String, authorization: String): EduManager {
            return EduManagerImpl(appId, authorization)
        }
    }

    abstract fun <T : LocalUserService> createClassroom(params: CreateRoomParams, config: CreateRoomConfig, callback: Callback<ClassroomManager<T>>)

    abstract fun enableDebugMode(enable: Boolean)

    abstract fun log(logLevel: Level, log: String)

    abstract fun uploadLog(callback: Callback<String>)
}