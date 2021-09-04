package com.example.sleep.play

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep.R

class PlayActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var runnable: Runnable
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        handleExtras()
        setUpMediaPlayer()
        handleCloseButtonClick()
    }

    private fun handleExtras() {
        findViewById<TextView>(R.id.play_name).text = intent.extras?.getString("name")
        findViewById<TextView>(R.id.play_category).text = getString(
            R.string.play_category,
            intent.extras?.getString("categoryName")
        )
    }

    private fun setUpMediaPlayer() {
        mediaPlayer = MediaPlayer.create(
            this, resources.getIdentifier(
                "track_${intent.extras?.getInt("id")}",
                "raw",
                packageName
            )
        )

        val playButton = findViewById<ImageButton>(R.id.play_button)
        val seekBar = findViewById<SeekBar>(R.id.play_seek_bar)

        playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                playButton.setImageResource(R.drawable.ic_pause)
            } else {
                mediaPlayer.pause()
                playButton.setImageResource(R.drawable.ic_play)
            }
        }

        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val delayMillis = 1000.toLong()

        runnable = Runnable {
            if (mediaPlayer.isPlaying) {
                seekBar.progress = mediaPlayer.currentPosition
            }
            handler.postDelayed(runnable, delayMillis)
        }

        handler.postDelayed(runnable, delayMillis)

        mediaPlayer.setOnCompletionListener {
            playButton.setImageResource(R.drawable.ic_play)
            seekBar.progress = 0
        }

        val mSecStep = 15000

        findViewById<ImageButton>(R.id.play_back_button).setOnClickListener {
            mediaPlayer.seekTo(mediaPlayer.currentPosition - mSecStep)
            seekBar.progress = mediaPlayer.currentPosition
        }
        findViewById<ImageButton>(R.id.play_forward_button).setOnClickListener {
            mediaPlayer.seekTo(mediaPlayer.currentPosition + mSecStep)
            seekBar.progress = mediaPlayer.currentPosition
        }
    }

    private fun handleCloseButtonClick() {
        findViewById<ImageButton>(R.id.play_close_button).setOnClickListener {
            mediaPlayer.stop()
            finish()
        }
    }
}