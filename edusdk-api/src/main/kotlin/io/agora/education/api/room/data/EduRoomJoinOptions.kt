package io.agora.education.api.room.data

data class RoomMediaOptions(
        val autoSubscribeVideo: Boolean = true,
        val autoSubscribeAudio: Boolean = true,
        val autoPublishCamera: Boolean = true,
        val autoPublishMicrophone: Boolean = true
)

data class RoomJoinOptions(
        var userUuid: String,
        var userName: String,
        var mediaOptions: RoomMediaOptions
)
