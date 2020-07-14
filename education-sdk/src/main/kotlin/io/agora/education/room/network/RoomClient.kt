package io.agora.education.room.network

import io.agora.education.edumanager.bean.EduUser
import io.agora.education.room.bean.response.EduClassRoomEntryRes
import io.agora.education.room.bean.response.EduClassroomConfigRes
import io.agora.education.room.bean.response.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RoomClient {

    @GET("/scenario/education/apps/{appId}/v1/rooms/{roomId}/config")
    fun getClassroomConfig(
            @Path("appId") appId: String,
            @Path("roomId") roomId: String
    ): Call<ResponseBody<EduClassroomConfigRes>>

    @GET("/scenario/education/apps/{appId}/v1/rooms/{roomId}/info")
    fun getClassroomInfo(
            @Path("appId") appId: String,
            @Path("roomId") roomId: String
    )

    @POST("/scenario/education/apps/{appId}/v1/rooms/{roomId}/entry")
    fun joinClassroomAsStudent(
            @Path("appId") appId: String,
            @Path("roomId") roomId: String,
            @Body eduUser: EduUser
    ): Call<ResponseBody<EduClassRoomEntryRes>>


}