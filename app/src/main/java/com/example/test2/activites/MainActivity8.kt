package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.R
import com.example.test2.databinding.ActivityMain8Binding
import com.example.test2.utils.DataModelJson
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

class MainActivity8 : AppCompatActivity() {
    lateinit var binding:ActivityMain8Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataInJsonFile()
    }

    private fun getDataInJsonFile() {

        val list= arrayListOf<DataModelJson>()

        val inputStream=resources.openRawResource(R.raw.user)
        val json= convertStreamToString(inputStream)
        inputStream.close()

        val jsonObject=JSONObject(json)
        val array=jsonObject.optJSONArray("users")

        for (item in 0 until array.length()){
            val object1=array.getJSONObject(item)
            val name=object1.getString("name")
            val family=object1.getString("family")
            val age=object1.getString("age")

            list.add(DataModelJson(name,family,age))
        }

        //val adapter=DataAdapter(list)
       // binding.listView.adapter=adapter
    }

    private fun convertStreamToString(stream: InputStream):String {
        val bufferReader=BufferedReader(InputStreamReader(stream))
        var line:String
        val stringBuilder=StringBuilder()

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