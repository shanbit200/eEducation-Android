package io.agora.education.impl

import io.agora.base.callback.ThrowableCallback
import io.agora.base.network.BusinessException
import io.agora.base.network.RetrofitManager
import io.agora.education.api.EduCallback
import io.agora.education.api.EduManager
import io.agora.education.api.EduManagerOptions
import io.agora.education.api.logger.DebugItem
import io.agora.education.api.logger.LogLevel
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.EduRoomState
import io.agora.education.api.room.data.EduRoomStatus
import io.agora.education.api.room.data.RoomCreateOptions
import io.agora.education.impl.room.EduRoomImpl
import io.agora.education.impl.room.data.EduRoomInfoImpl
import io.agora.education.impl.room.data.request.RoomCreateOptionsReq
import io.agora.education.impl.room.network.RoomService
import io.agora.education.impl.room.data.response.ResponseBody
import io.agora.rte.RteEngineImpl

internal class EduManagerImpl(
        options: EduManagerOptions
) : EduManager(options) {
    init {
        RteEngineImpl.init(options.context, options.appId)
    }

    override fun createClassroom(config: RoomCreateOptions, callback: EduCallback<EduRoom>) {
        RetrofitManager.instance().getService("", RoomService::class.java)
                .createClassroom("", RoomCreateOptionsReq.convertToSelf(config))
                .enqueue(RetrofitManager.Callback(0, object : ThrowableCallback<ResponseBody<Int>> {
                    /**接口返回Int类型的roomId*/
                    override fun onSuccess(res: ResponseBody<Int>?) {
                        val eduRoomInfo = EduRoomInfoImpl(res?.data.toString(), config.roomUuid, config.roomName)
                        val eduRoomStatus = EduRoomStatus(EduRoomState.START, System.currentTimeMillis(), true, 0)
                        callback.onSuccess(EduRoomImpl(eduRoomInfo, eduRoomStatus))
                    }

                    override fun onFailure(throwable: Throwable?) {
                        val error = throwable as BusinessException
                        callback.onFailure(error.code, error.message)
                    }
                }))
    }

    override fun logMessage(message: String, level: LogLevel) {
        TODO("Not yet implemented")
    }

    override fun uploadDebugItem(item: DebugItem, callback: EduCallback<String>) {
        TODO("Not yet implemented")
    }
}
