package io.agora.education.board

import io.agora.education.edumanager.EduUser

interface EduBoardDelegate {
    fun onFollowMode(enable: Boolean): Void

    fun onPermissionGranted(student: EduUser)

    fun onPermissionRevoked(student: EduUser)
}