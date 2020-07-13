package io.agora.education.edumanager.bean

import io.agora.education.user.enums.EduRoleType

class EduUser constructor() {
    /**原来的userId内部隐藏，不暴露给客户*/
    lateinit var userUuid: String
    lateinit var userName: String
    lateinit var role: EduRoleType

    constructor(userUuid: String, userName: String, role: EduRoleType) : this() {
        this.userUuid = userUuid
        this.userName = userName
        this.role = role
    }
}