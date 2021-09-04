package com.example.sleep.track

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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

        findViewById<TextView>(R.id.track_name).text = intent.extras?.get("name") as CharSequence
        findViewById<TextView>(R.id.track_info).text = getString(
            R.string.track_info,
            intent.extras?.get("minutes") as Int,
            intent.extras?.get("categoryName")
        )
        findViewById<TextView>(R.id.track_description).text = intent.extras?.get("description") as CharSequence
        findViewById<TextView>(R.id.track_favorites_label).text = getString(
            R.string.track_favorites,
            intent.extras?.get("favorites") as Int,
        )
        findViewById<TextView>(R.id.track_listening_label).text = getString(
            R.string.track_listening,
            intent.extras?.get("listening") as Int,
        )
    }

    private fun handleBackButtonClick() {
        findViewById<ImageButton>(R.id.track_back_button).setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}