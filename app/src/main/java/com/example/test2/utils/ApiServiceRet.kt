package com.example.test2.utils

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceRet {
    @GET("temp/user.json")
    fun getUsers():Call<List<Users>>

    @POST("school/index.php/api/get_video")
    @FormUrlEncoded
    fun getVideos(@Field("standard_id") standard_id:Int):Call<List<Videos>>
}