package io.agora.education

import android.content.Context
import io.agora.base.callback.Callback
import io.agora.education.classroom.ClassroomManager
import io.agora.education.classroom.RoomConfig
import io.agora.education.impl.EduManagerImpl
import io.agora.education.user.LocalUserService
import java.util.logging.Level

data class EduSdkConfig(
        var appId: String,
        var authorization: String
)

abstract class EduManager internal constructor(
        protected val context: Context,
        protected val config: EduSdkConfig
) {
    companion object {
        @JvmStatic
        fun init(context: Context, config: EduSdkConfig): EduManager {
            return EduManagerImpl(context, config)
        }

        @JvmStatic
        fun getSdkVersion(): String {
            return ""
        }
    }

    abstract fun <T : LocalUserService> createClassroom(config: RoomConfig, callback: Callback<ClassroomManager<T>>)

    abstract fun enableDebugMode(enable: Boolean)

    abstract fun log(logLevel: Level, log: String)

    abstract fun uploadLog(callback: Callback<String>)
}
