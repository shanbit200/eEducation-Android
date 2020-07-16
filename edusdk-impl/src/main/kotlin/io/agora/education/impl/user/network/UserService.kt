package io.agora.education.impl.user.network

import io.agora.education.impl.user.data.request.EduPublishStreamReq
import io.agora.education.impl.user.data.request.EduRoomMsgReq
import io.agora.education.impl.user.data.request.EduUserMsgReq
import io.agora.education.impl.user.data.response.EduPublishStreamRes
import io.agora.education.impl.user.data.response.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @POST("/scenario/education/apps/{appId}/v1/rooms/{roomId}/streams")
    fun publishStream(
            @Header("userToken") userToken:String,
            @Path("appId") appId: String,
            @Path("roomId") roomId: String,
            @Body eduPublishStreamReq: EduPublishStreamReq
    ): Call<ResponseBody<EduPublishStreamRes>>

    @DELETE("/scenario/education/apps/{appId}/v1/rooms/{roomId}/streams/{streamId}")
    fun unPublishStream(
            @Header("userToken") userToken: String,
            @Path("appId") appId: String,
            @Path("roomId") roomId: String,
            @Path("streamId") streamId: String
    ): Call<ResponseBody<Boolean>>

    @GET("/scenario/education/apps/{appId}/v1/rooms/{roomId}/message/broadcast")
    fun sendRoomMessage(
            @Header("userToken") userToken: String,
            @Path("appId") appId: String,
            @Path("roomId") roomId: String,
            @Body eduRoomMsgReq: EduRoomMsgReq
    ): Call<ResponseBody<Boolean>>

    @GET("/scenario/education/apps/{appId}/v1/rooms/{roomId}/message/peer")
    fun sendUserMessage(
            @Header("userToken") userToken: String,
            @Path("appId") appId: String,
            @Path("roomId") roomId: String,
            @Body eduUserMsgReq: EduUserMsgReq
    ): Call<ResponseBody<Boolean>>
}