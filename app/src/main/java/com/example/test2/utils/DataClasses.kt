package com.example.test2.utils

data class Main(
    val array:List<Users>
)

data class Users(
    val name:String,
    val family:String,
    val age:String
)
data class Videos(
    val responce:Boolean,
    val array: List<ArrayVideos>
)
data class ArrayVideos(
    val video_id:Int,
    val video_title:String,
    val video_author:String,
    val video_description:String,
    val video_file:String,
    val school_id:Int,
    val group_id:Int,
    val dore_id:Int

)
