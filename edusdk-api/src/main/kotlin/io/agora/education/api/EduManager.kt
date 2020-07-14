package io.agora.education.api

import io.agora.education.api.logger.DebugItem
import io.agora.education.api.logger.LogLevel
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.RoomCreateOptions

abstract class EduManager {
    lateinit var options: EduManagerOptions

    companion object {
        @JvmStatic
        fun init(options: EduManagerOptions): EduManager {
            val eduManager = Class.forName("io.agora.education.impl.EduManagerImpl").getConstructor().newInstance() as EduManager
            eduManager.options = options
            return eduManager
        }
    }

    abstract fun createClassroom(config: RoomCreateOptions, callback: EduCallback<EduRoom>)

    abstract fun logMessage(message: String, level: LogLevel)

    abstract fun uploadDebugItem(item: DebugItem, callback: EduCallback<String>)
}
