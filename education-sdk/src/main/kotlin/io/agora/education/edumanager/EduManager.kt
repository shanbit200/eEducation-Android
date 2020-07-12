package io.agora.education.edumanager

import io.agora.base.callback.Callback
import io.agora.education.room.EduClassroomConfig
import io.agora.education.room.EduClassroomManager
import io.agora.education.statistics.DebugItem
import io.agora.education.statistics.LogLevel

abstract class EduManager internal constructor(
        protected val config: EduSdkConfig
) {
    companion object {
        @JvmStatic
        fun init(config: EduSdkConfig): EduManager {
            return EduManagerImpl(config)
        }
    }

    abstract fun createClassroom(config: EduClassroomConfig,
                                 success: (classRoomManager: EduClassroomManager) -> Unit,
                                 failure: (throwable: Throwable) -> Unit)

    abstract fun enableDebugMode(enable: Boolean)

    abstract fun log(log: String, logLevel: LogLevel)

    abstract fun uploadLog(debugItem: DebugItem, callback: Callback<String>)
}
