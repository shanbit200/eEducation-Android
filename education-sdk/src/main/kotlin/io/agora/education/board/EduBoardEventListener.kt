package io.agora.education.board

import io.agora.education.edumanager.bean.EduUser

interface EduBoardEventListener {
    fun onFollowMode(enable: Boolean): Void

    fun onPermissionGranted(student: EduUser)

    fun onPermissionRevoked(student: EduUser)
}