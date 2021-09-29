package com.example.test2.utils

data class DataModelRecycler(val image:Int,val price:String)
data class DataModelRecycler2(val image:Int,val title:String,val brand:String,val price:String)
data class DataModel(val name:String,val img:String)
data class DataModelUser(val id:Int,val name:String,val family:String)
data class DataModelJson(val name:String,val family:String,val age:String)
data class DataModelWeather(val desc:String,val speed:Double,val humidity:Int)