package io.agora.education.board.bean

import io.agora.education.edumanager.bean.EduUser

class EduBoardOperator constructor() {
    var isPublisher: Boolean = false
    lateinit var user: EduUser

    constructor(isPublisher: Boolean, user: EduUser): this() {
        this.isPublisher = isPublisher
        this.user = user
    }
}