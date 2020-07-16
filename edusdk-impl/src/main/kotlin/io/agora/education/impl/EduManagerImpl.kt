package io.agora.education.impl

import io.agora.base.callback.ThrowableCallback
import io.agora.base.network.RetrofitManager
import io.agora.education.BuildConfig
import io.agora.education.api.EduCallback
import io.agora.education.api.EduManager
import io.agora.education.api.EduManagerOptions
import io.agora.education.api.board.EduBoard
import io.agora.education.api.logger.DebugItem
import io.agora.education.api.logger.LogLevel
import io.agora.education.api.record.EduRecord
import io.agora.education.api.room.EduRoom
import io.agora.education.api.room.data.*
import io.agora.education.api.user.EduStudent
import io.agora.education.api.user.EduUser
import io.agora.education.impl.board.EduBoardImpl
import io.agora.education.impl.record.EduRecordImpl
import io.agora.education.impl.room.EduRoomImpl
import io.agora.education.impl.room.data.EduRoomInfoImpl
import io.agora.education.impl.room.data.request.RoomCreateOptionsReq
import io.agora.education.impl.room.network.RoomService
import io.agora.education.impl.user.EduUserImpl
import io.agora.education.room.bean.response.ResponseBody
import io.agora.rte.RteEngineImpl

internal class EduManagerImpl(
        options: EduManagerOptions
) : EduManager(options) {
    init {
        RteEngineImpl.init(options.context, options.appId)
    }

    private val eduUser: EduUser = EduUserImpl()
    private val eduBoard: EduBoard = EduBoardImpl()
    private val eduRecord: EduRecord = EduRecordImpl()
    private lateinit var eduRoom: EduRoom

    override fun createClassroom(config: RoomCreateOptions, callback: EduCallback<EduRoom>) {

        RetrofitManager.instance().getService("", RoomService::class.java)
                .createClassroom("", RoomCreateOptionsReq.convertToSelf(config))
                .enqueue(RetrofitManager.Callback(0, object : ThrowableCallback<ResponseBody<Int>> {
                    /**接口返回Int类型的roomId*/
                    override fun onSuccess(res: ResponseBody<Int>?) {
                        var eduRoomInfo = EduRoomInfoImpl(res?.data.toString(), config.roomUuid, config.roomName)
                        var eduRoomStatus = EduRoomStatus(EduRoomState.START, System.currentTimeMillis(), true, 0)
                        eduRoom = EduRoomImpl(eduRoomInfo, eduRoomStatus, null)
                        eduRoom.localUser = eduUser
                        eduRoom.board = eduBoard
                        eduRoom.record = eduRecord
                        callback.onSuccess(eduRoom)
                    }

                    override fun onFailure(throwable: Throwable?) {
                        callback.onFailure(-1, throwable?.message)
                    }
                }))

        RteEngineImpl.createChannel(config.roomId)

    }

    override fun logMessage(message: String, level: LogLevel) {
        TODO("Not yet implemented")
    }

    override fun uploadDebugItem(item: DebugItem, callback: EduCallback<String>) {
        TODO("Not yet implemented")
    }
}
