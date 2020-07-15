package io.agora.education.impl

import io.agora.education.api.EduCallback
import io.agora.education.api.EduManager
import io.agora.education.api.logger.DebugItem
import io.agora.education.api.logger.LogLevel
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.RoomCreateOptions
import io.agora.sdk.manager.RtmManager
import io.agora.sdk.manager.SdkManager

internal class EduManagerImpl : EduManager() {
    override fun createClassroom(config: RoomCreateOptions, callback: EduCallback<EduRoom>) {
        RtmManager.instance().joinChannel(mutableMapOf(
                SdkManager.CHANNEL_ID to config.roomId
        ))
        TODO("Not yet implemented")
    }

    override fun logMessage(message: String, level: LogLevel) {
        TODO("Not yet implemented")
    }

    override fun uploadDebugItem(item: DebugItem, callback: EduCallback<String>) {
        TODO("Not yet implemented")
    }
}