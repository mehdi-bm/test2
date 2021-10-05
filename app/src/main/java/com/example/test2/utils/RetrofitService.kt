package com.example.test2.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitService {
    fun getUsers(onUsersJsonReceived: OnUsersJsonReceived){
        val callBack= ApiClient().getClient().create(ApiServiceRet::class.java).getUsers()

        callBack.enqueue(object :Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                val values=response.body()
                if(values!=null)
                onUsersJsonReceived.onRecieved(values)
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun getVideos(onVideosJsonReceived: onVideosJsonReceived){
        val callBack= ApiClient().getClient().create(ApiServiceRet::class.java).getVideos(35)

        callBack.enqueue(object :Callback<List<Videos>>{
            override fun onResponse(call: Call<List<Videos>>, response: Response<List<Videos>>) {
                val values=response.body()
                if (values!=null)
                    onVideosJsonReceived.onRecieved(values)
            }

            override fun onFailure(call: Call<List<Videos>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    interface OnUsersJsonReceived{
        fun onRecieved(userInfo:List<Users>)
    }
    interface onVideosJsonReceived{
        fun onRecieved(videoInfo:List<Videos>)
    }

}