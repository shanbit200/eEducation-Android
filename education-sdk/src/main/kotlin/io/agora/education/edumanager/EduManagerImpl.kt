package io.agora.education.edumanager

import io.agora.base.callback.Callback
import io.agora.education.edumanager.bean.EduSdkConfig
import io.agora.education.edumanager.enums.DebugItem
import io.agora.education.edumanager.enums.LogLevel
import io.agora.education.room.bean.EduClassroomConfig
import io.agora.education.room.EduClassroomManager

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

    override fun uploadLog(debugItem: DebugItem, success: (uploadSerialNumber: String) -> Unit) {
        TODO("Not yet implemented")
    }
}
