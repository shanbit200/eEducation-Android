package io.agora.education.impl.user.request

import io.agora.education.api.stream.data.EduAudioSourceType
import io.agora.education.api.stream.data.EduVideoSourceType

/**@param streamUuid 同一appId下流的唯一id，rtc中uid
 * @param isPublish 1发布 0不发布*/
class EduPublishStreamReq constructor(var userId: String,
                                      var streamUuid: String,
                                      var streamName: String,
                                      var videoSourceType: EduVideoSourceType,
                                      var audioSourceType: EduAudioSourceType,
                                      var hasVideo: Int, var hasAudio: Int) {

}