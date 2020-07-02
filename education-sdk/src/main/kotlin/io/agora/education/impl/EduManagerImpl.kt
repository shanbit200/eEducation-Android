package io.agora.education.impl

import android.content.Context
import io.agora.base.callback.Callback
import io.agora.education.EduManager
import io.agora.education.EduSdkConfig
import io.agora.education.classroom.ClassroomManager
import io.agora.education.classroom.RoomConfig
import io.agora.education.user.LocalUserService
import java.util.logging.Level

internal class EduManagerImpl internal constructor(
        context: Context,
        config: EduSdkConfig
) : EduManager(context, config) {
    override fun <T : LocalUserService> createClassroom(config: RoomConfig, callback: Callback<ClassroomManager<T>>) {
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
