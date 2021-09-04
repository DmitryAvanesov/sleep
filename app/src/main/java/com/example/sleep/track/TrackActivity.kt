package com.example.sleep.track

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep.R
import com.example.sleep.list.ListActivity
import com.example.sleep.list.ListFragment

class TrackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)
        handleExtras()
        setListFragment()
        handleBackButtonClick()
    }

    private fun handleExtras() {
        findViewById<ImageView>(R.id.track_image).setImageResource(
            resources.getIdentifier(
                "track_${intent.extras?.getInt("id")}",
                "drawable",
                packageName
            )
        )

        findViewById<TextView>(R.id.track_name).text = intent.extras?.getCharSequence("name")
        findViewById<TextView>(R.id.track_info).text = getString(
            R.string.track_info,
            intent.extras?.getInt("minutes"),
            intent.extras?.get("categoryName")
        )
        findViewById<TextView>(R.id.track_description).text =
            intent.extras?.getCharSequence("description")
        findViewById<TextView>(R.id.track_favorites_label).text = getString(
            R.string.track_favorites,
            intent.extras?.getInt("favorites"),
        )
        findViewById<TextView>(R.id.track_listening_label).text = getString(
            R.string.track_listening,
            intent.extras?.getInt("listening"),
        )
    }

    private fun setListFragment() {
        val fragment = ListFragment.newInstance(
            categoryId = intent.extras?.getInt("categoryId") ?: 0,
            trackId = intent.extras?.getInt("id") ?: 0
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.track_related_list_container, fragment)
            .commit()
    }

    private fun handleBackButtonClick() {
        findViewById<ImageButton>(R.id.track_back_button).setOnClickListener {
            finish()
        }
    }
}