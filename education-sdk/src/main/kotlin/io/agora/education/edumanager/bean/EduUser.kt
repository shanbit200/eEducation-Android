package io.agora.education.edumanager.bean

import io.agora.education.user.enums.EduRoleType

class EduUser constructor() {
    private lateinit var userId: String
    lateinit var userUuid: String
    lateinit var userName: String
    lateinit var role: EduRoleType

    constructor(userId: String, userUuid: String, userName: String, role: EduRoleType) : this() {
        this.userId = userId
        this.userUuid = userUuid
        this.userName = userName
        this.role = role
    }
}