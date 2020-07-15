package io.agora.education.impl.room.data.response

import io.agora.education.api.user.data.EduUserRole

class EduUserRes constructor(var userId: String,
                             var userUuid: String,
                             var userName: String,
                             var role: EduUserRole) {
}