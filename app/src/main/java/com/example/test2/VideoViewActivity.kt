package com.example.test2


import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AlertDialog
import com.example.test2.databinding.ActivityVideoviewBinding

import java.lang.Exception


class VideoViewActivity : AppCompatActivity() {
    private lateinit var mediaController: MediaController
    private var position=0
    private lateinit var binding:ActivityVideoviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVideoviewBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        mediaController= MediaController(this)


        binding.videoView.setOnPreparedListener {
            //mediaController.show(binding.videoView.duration)
            binding.videoView!!.seekTo(position)
            if(position==0)
                binding.videoView.start()
            else
                binding.videoView.pause()
            //video.pause()
            //video.stopPlayback()
        }

        loadVideo()



    }
    private fun loadVideo(){
        val uriVideo="android.resource://$packageName"
        val conManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo=conManager.activeNetworkInfo


        if (netInfo!=null && netInfo.isConnected){
            try {
                binding.videoView.setMediaController(mediaController)
                //binding.videoView.setVideoURI(Uri.parse("$uriVideo/${R.raw.parsik_amoozeshtest}"))
                binding.videoView.setVideoURI(Uri.parse("https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/Kotlin-1249867/S03-Part36-VideoView2.mp4"))

            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }else{
            AlertDialog.Builder(this)
                .setTitle("No Internet")
                .setMessage("Change Internet State and Reload")
                .setPositiveButton("Reload"){_,_->
                    loadVideo()
                }
                .setNegativeButton("Cancel"){_,_->

                }
                .create()
                .show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("position",binding.videoView.currentPosition)
        binding.videoView.pause()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        position= savedInstanceState.getInt("position")
        binding.videoView.seekTo(position)
    }

}

