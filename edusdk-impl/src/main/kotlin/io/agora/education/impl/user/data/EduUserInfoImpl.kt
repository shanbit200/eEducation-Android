package io.agora.education.impl.user.data

import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.api.user.data.EduUserRole

class EduUserInfoImpl(private val userId: String, userUuid: String, userName: String, role: EduUserRole)
    : EduUserInfo(userUuid, userName, role) {
}