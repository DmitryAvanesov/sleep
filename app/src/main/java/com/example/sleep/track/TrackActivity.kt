package com.example.sleep.track

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep.R
import com.example.sleep.list.ListActivity

class TrackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)
        handleExtras()
        handleBackButtonClick()
    }

    private fun handleExtras() {
        findViewById<ImageView>(R.id.track_image).setImageResource(
            resources.getIdentifier(
                "track_${intent.extras?.get("id")}",
                "drawable",
                packageName
            )
        )
    }

    private fun handleBackButtonClick() {
        findViewById<ImageButton>(R.id.track_back_button).setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}