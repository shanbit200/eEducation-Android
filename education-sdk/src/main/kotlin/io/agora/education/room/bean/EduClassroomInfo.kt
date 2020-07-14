package io.agora.education.room.bean

class EduClassroomInfo constructor() {
    /**客户提供uuid，内部使用该uuid作为RTC/RTM 的channel name
     * 原来的roomId内部隐藏，不暴露给客户*/
    private lateinit var roomId: String
    lateinit var roomUuid: String
    lateinit var roomName: String

    constructor(roomId: String, roomUuid: String, roomName: String): this() {
        this.roomId = roomId
        this.roomUuid = roomUuid
        this.roomName = roomName
    }
}