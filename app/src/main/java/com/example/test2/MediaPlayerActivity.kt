package com.example.test2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityMediaPlayerBinding
import de.hdodenhof.circleimageview.CircleImageView

class MediaPlayerActivity : AppCompatActivity() {
    private var isPlay=false
    private lateinit var binding: ActivityMediaPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //val mediaPlayer = MediaPlayer()
        //online mediaPlayer.setDataSource("url")
        var mediaPlayer = MediaPlayer.create(this, R.raw.misagh_radgolesorkh)

        binding.apply {

            imgMediaPlay.setOnClickListener {
                isPlay = if (!isPlay) {
                    mediaPlayer.start()
                    imgMediaPlay.setImageResource(R.drawable.media_playback_pause_icon)
                    true
                } else {
                    mediaPlayer.pause()
                    imgMediaPlay.setImageResource(R.drawable.media_playback_start_icon)
                    false
                }


            }
            imgMediaForward.setOnClickListener {
                mediaPlayer.seekTo(mediaPlayer.currentPosition+5000)
            }
            imgMediaBackground.setOnClickListener {
                mediaPlayer.seekTo(mediaPlayer.currentPosition-5000)
            }
            imgMediaStop.setOnClickListener {
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this@MediaPlayerActivity, R.raw.misagh_radgolesorkh)
                imgMediaPlay.setImageResource(R.drawable.media_playback_start_icon)
                isPlay=false
            }
        }
    }
}