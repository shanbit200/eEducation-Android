package io.agora.education.room.bean.response

import io.agora.education.edumanager.bean.EduUser
import io.agora.education.edumanager.enums.EduAudioSourceType
import io.agora.education.edumanager.enums.EduVideoSourceType

class EduStreamListRes constructor(var count: Int,
                                   var total: Int,
                                   var nextId: String,
                                   var list: ArrayList<EduStreamRes>) {
}

class EduStreamRes constructor(var streamId: String,
                               var streamUuid: String, var streamName: String,
                               var videoSourceType: EduVideoSourceType,
                               var audioSourceType: EduAudioSourceType,
                               var hasVideo: Boolean, var hasAudio: Boolean,
                               var isPublish: Boolean, var fromUser: EduUser) {
}