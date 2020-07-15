package io.agora.education.room.bean.response

import io.agora.education.api.stream.data.EduStreamInfo
import io.agora.education.api.user.data.EduUserInfo
import io.agora.education.impl.room.data.response.EduStreamRes
import io.agora.education.impl.room.data.response.EduUserRes

class Page constructor(var count: Int,
                       var total: Int,
                       var nextId: String,
                       var list: ArrayList<Any>) {

    fun convertToTarget() {
        if (list?.size == 0) {
            return
        }
        if (list[0] is EduUserRes) {
            for ((index, element) in list.withIndex()) {
                var eduUserRes = element as EduUserRes
                var eduUser = EduUserInfo(eduUserRes.userId, eduUserRes.userUuid,
                        eduUserRes.userName, eduUserRes.role)
                list[index] = eduUser
            }
        } else if (list[0] is EduStreamRes) {
            for ((index, element) in list.withIndex()) {
                var eduStreamRes = element as EduStreamRes
                var eduStream = EduStreamInfo(eduStreamRes.streamUuid, eduStreamRes.streamName,
                        eduStreamRes.streamId.toInt(), eduStreamRes.videoSourceType,
                        eduStreamRes.audioSourceType, eduStreamRes.hasVideo,
                        eduStreamRes.hasAudio, eduStreamRes.fromUser)
                list[index] = eduStream
            }
        }
    }
}