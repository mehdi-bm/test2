package com.example.test2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.MediaController
import android.widget.VideoView
import java.lang.Exception


class MainActivity7 : AppCompatActivity() {
    private lateinit var mediaController: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        mediaController= MediaController(this)

        val uriVideo="android.resource://$packageName"
        val video=findViewById<VideoView>(R.id.videoView)

        try {
            video.setMediaController(mediaController)
            video.setVideoURI(Uri.parse("$uriVideo/${R.raw.parsik_amoozeshtest}"))
            video.setOnPreparedListener {
                mediaController.show(video.duration)

                //video.start()
                //video.pause()
                //video.stopPlayback()
            }
            video.setOnErrorListener { mp, what, extra ->
                false
            }
            video.setOnCompletionListener {

            }
        }catch (ex:Exception){
            ex.printStackTrace()
        }

    }



    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }
}