package io.agora.education.api.user.listener

import io.agora.education.api.stream.data.EduStreamInfo

interface EduUserEventListener {
    fun onLocalStreamAdded(stream: EduStreamInfo)

    fun onLocalStreamUpdated(stream: EduStreamInfo)

    fun onLocalSteamRemoved(stream: EduStreamInfo)
}
