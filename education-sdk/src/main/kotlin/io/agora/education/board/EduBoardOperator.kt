package io.agora.education.board

import io.agora.education.edumanager.EduUser

class EduBoardOperator constructor() {
    var isMaster: Boolean = false
    lateinit var user: EduUser

    constructor(isMaster: Boolean, user: EduUser): this() {
        this.isMaster = isMaster
        this.user = user
    }
}