package io.agora.education.edumanager

import io.agora.base.callback.Callback
import io.agora.education.edumanager.bean.EduSdkConfig
import io.agora.education.edumanager.enums.DebugItem
import io.agora.education.edumanager.enums.LogLevel
import io.agora.education.room.bean.EduClassroomConfig
import io.agora.education.room.EduClassroomManager

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

    abstract fun uploadLog(debugItem: DebugItem, success: (uploadSerialNumber: String) -> Unit)
}
