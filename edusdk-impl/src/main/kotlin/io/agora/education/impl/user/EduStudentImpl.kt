package io.agora.education.impl.user

import io.agora.education.api.user.EduStudent
import io.agora.education.api.user.listener.EduStudentEventListener

internal class EduStudentImpl : EduUserImpl(), EduStudent {
    init {
        userInfo
    }

    override fun setEventListener(eventListener: EduStudentEventListener) {
        this.eventListener = eventListener
    }
}
