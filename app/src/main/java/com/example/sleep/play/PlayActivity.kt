package com.example.sleep.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.sleep.R

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        handleExtras()
        handleCloseButtonClick()
    }

    private fun handleExtras() {
        findViewById<TextView>(R.id.play_name).text = intent.extras?.getString("name")
        findViewById<TextView>(R.id.play_category).text = getString(
            R.string.play_category,
            intent.extras?.getString("categoryName")
        )
    }

    private fun handleCloseButtonClick() {
        findViewById<ImageButton>(R.id.play_close_button).setOnClickListener {
            finish()
        }
    }
}