package com.example.test2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.test2.databinding.ActivityMain9Binding
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity9 : AppCompatActivity() {
    lateinit var binding:ActivityMain9Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMain9ShowWeather.setOnClickListener {
            if(binding.txtMain9CityName.text.toString()=="") {
                Toast.makeText(this, "لطفا شهر مورد نظر شما را وارد نمایید", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
          val city=binding.txtMain9CityName.text.toString()
            //api
           // getData(city)

            //volley
            getDataInVolley(city)
        }

    }

    private fun getDataInVolley(cityName: String) {
        val api="https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=62a82e85aad1428feccb1e22cac0d596"
        val request=JsonObjectRequest(Request.Method.GET,api,null,
            Response.Listener{
                val weather=it.getJSONArray("weather")
                val main=it.getJSONObject("main")
                val wind=it.getJSONObject("wind")


                val array=weather.getJSONObject(0)

                val description=array.getString("description")
                val humidity=main.getInt("humidity")
                val speed=wind.getDouble("speed")

                binding.txtMain9Condition.text=description
                binding.txtMain9Wet.text=humidity.toString()
                binding.txtMain9Speed.text=speed.toString()
        }, Response.ErrorListener {

        })
        request.retryPolicy=DefaultRetryPolicy(10000,1,1f)
        val requestQueue=Volley.newRequestQueue(this)
        requestQueue.add(request)

    }

    private fun getData(cityName:String) {
        val api="https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=62a82e85aad1428feccb1e22cac0d596"
        MyAsyncTask().execute(api)
    }

   inner class MyAsyncTask:AsyncTask<String,String,String>(){
        override fun doInBackground(vararg p0: String?): String {
            val url=URL(p0[0])
            val connection=url.openConnection() as HttpsURLConnection
            connection.connectTimeout=10000
               val json=convertStreamToString(connection.inputStream)
            publishProgress(json)
            return ""
        }

       override fun onProgressUpdate(vararg values: String?) {
           super.onProgressUpdate(*values)

           val jsonObject=JSONObject(values[0])
           val weather=jsonObject.getJSONArray("weather")
           val main=jsonObject.getJSONObject("main")
           val wind=jsonObject.getJSONObject("wind")


           val array=weather.getJSONObject(0)

          val description=array.getString("description")
           val humidity=main.getInt("humidity")
           val speed=wind.getDouble("speed")

           binding.txtMain9Condition.text=description
           binding.txtMain9Wet.text=humidity.toString()
           binding.txtMain9Speed.text=speed.toString()
       }

    }

    private fun convertStreamToString(stream: InputStream):String {
        val bufferReader= BufferedReader(InputStreamReader(stream))
        var line:String
        val stringBuilder= StringBuilder()

        try {
            do {
                line=bufferReader.readLine()
                stringBuilder.append(line)
            }while (true)

        }catch (ex:Exception){
            ex.printStackTrace()
        }
        return stringBuilder.toString()
    }
}