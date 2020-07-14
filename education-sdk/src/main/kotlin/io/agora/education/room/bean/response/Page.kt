package io.agora.education.room.bean.response

import io.agora.education.edumanager.bean.EduStream
import io.agora.education.edumanager.bean.EduUser

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
                var eduUser = EduUser(eduUserRes.userId, eduUserRes.userUuid,
                        eduUserRes.userName, eduUserRes.role)
                list[index] = eduUser
            }
        } else if (list[0] is EduStreamRes) {
            for ((index, element) in list.withIndex()) {
                var eduStreamRes = element as EduStreamRes
                var eduStream = EduStream(eduStreamRes.streamId, eduStreamRes.streamUuid,
                        eduStreamRes.streamName, eduStreamRes.videoSourceType,
                        eduStreamRes.audioSourceType, eduStreamRes.hasVideo,
                        eduStreamRes.hasAudio, eduStreamRes.isPublish,
                        eduStreamRes.fromUser)
                list[index] = eduStream
            }
        }
    }
}