package io.agora.education.room.bean

import io.agora.education.room.EduClassroomManager.Companion.kStreamLimit
import io.agora.education.room.EduClassroomManager.Companion.kStudentLimit
import io.agora.education.room.EduClassroomManager.Companion.kTeacherLimit
import io.agora.education.room.enums.EduClassroomType

class EduClassroomConfig constructor() {
    private lateinit var roomId: String
    lateinit var roomName: String
    lateinit var roomUuid: String
    lateinit var classType: EduClassroomType
    lateinit var roomProperty: Array<RoomProperty?>
    var propertyCount: Int = 0

    constructor(roomId: String, roomName: String, roomUuid: String, classType: EduClassroomType) : this() {
        this.roomId = roomId
        this.roomName = roomName
        this.roomUuid = roomUuid
        this.classType = classType
        propertyCount = 3
        roomProperty = arrayOfNulls(propertyCount)

        var streamLimitValue: Int = 17
        var streamLimitProperty: RoomProperty = RoomProperty(kStreamLimit, streamLimitValue)
        roomProperty[0] = streamLimitProperty

        var teacherLimitValue: Int = 1
        var teacherLimitProperty: RoomProperty = RoomProperty(kTeacherLimit, teacherLimitValue)
        roomProperty[1] = teacherLimitProperty

        var studentLimitValue: Int = -1
        when (classType) {
            EduClassroomType.EduClassroomType1V1 -> {
                studentLimitValue = 1
            }
            EduClassroomType.EduClassroomTypeSmall -> {
                studentLimitValue = 16
            }
            EduClassroomType.EduClassroomTypeBig -> {
            }
            else -> {

            }
        }
        var studentLimitProperty: RoomProperty = RoomProperty(kStudentLimit, studentLimitValue)
        roomProperty[2] = studentLimitProperty
    }

    constructor(roomId: String, roomName: String, roomUuid: String): this() {
        this.roomId = roomId
        this.roomName = roomName
        this.roomUuid = roomUuid
    }

    constructor(roomId: String, roomName: String, roomUuid: String, classType: EduClassroomType,
                roomProperty: Array<RoomProperty?>, propertyCount: Int): this() {
        this.roomId = roomId
        this.roomName = roomName
        this.roomUuid = roomUuid
        this.classType = classType
        this.roomProperty = roomProperty
        this.propertyCount = propertyCount
    }
}