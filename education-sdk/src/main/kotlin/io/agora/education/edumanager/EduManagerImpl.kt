package io.agora.education.edumanager

import io.agora.base.callback.Callback
import io.agora.education.room.EduClassroomConfig
import io.agora.education.room.EduClassroomManager
import io.agora.education.statistics.DebugItem
import io.agora.education.statistics.LogLevel

internal class EduManagerImpl internal constructor(
        config: EduSdkConfig
) : EduManager(config) {
    override fun createClassroom(classRoomConfig: EduClassroomConfig,
                                 success: (classRoomManager: EduClassroomManager) -> Unit,
                                 failure: (throwable: Throwable) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun enableDebugMode(enable: Boolean) {
        TODO("Not yet implemented")
    }

    override fun log(log: String, logLevel: LogLevel) {
        TODO("Not yet implemented")
    }

    override fun uploadLog(debugItem: DebugItem, callback: Callback<String>) {
        TODO("Not yet implemented")
    }
}
