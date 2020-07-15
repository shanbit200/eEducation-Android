package io.agora.education.impl.room.data.response

import io.agora.education.api.stream.data.EduAudioSourceType
import io.agora.education.api.stream.data.EduVideoSourceType
import io.agora.education.api.user.data.EduUserInfo

class EduStreamRes constructor(var streamId: String,
                               var streamUuid: String, var streamName: String,
                               var videoSourceType: EduVideoSourceType,
                               var audioSourceType: EduAudioSourceType,
                               var hasVideo: Boolean, var hasAudio: Boolean,
                               var fromUser: EduUserInfo) {
}