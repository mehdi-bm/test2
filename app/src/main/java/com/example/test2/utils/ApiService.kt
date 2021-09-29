package com.example.test2.utils

import android.content.Context
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class ApiService(private val context: Context) {
     fun getDataInVolley(cityName: String,onWeatherInfoReceived: OnWeatherInfoReceived) {
        val api="https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=62a82e85aad1428feccb1e22cac0d596"
        val request= JsonObjectRequest(Request.Method.GET,api,null,
            Response.Listener{
             val dataClass=   jsonParse(it)
                onWeatherInfoReceived.OnReceived(dataClass)
            }, Response.ErrorListener {

            })
        request.retryPolicy= DefaultRetryPolicy(10000,1,1f)
        val requestQueue= Volley.newRequestQueue(context)
        requestQueue.add(request)

    }
   private fun jsonParse(jsonObject: JSONObject):DataModelWeather{
        val weather=jsonObject.getJSONArray("weather")
        val main=jsonObject.getJSONObject("main")
        val wind=jsonObject.getJSONObject("wind")


        val array=weather.getJSONObject(0)

        val description=array.getString("description")
        val humidity=main.getInt("humidity")
        val speed=wind.getDouble("speed")

        return DataModelWeather(description,speed,humidity)
    }

    interface OnWeatherInfoReceived{
        fun OnReceived(dataModelWeather: DataModelWeather)
    }
}