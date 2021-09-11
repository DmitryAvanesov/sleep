package com.example.sleep.track

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep.R
import com.example.sleep.core.ListFragment
import com.example.sleep.play.PlayActivity
import kotlin.properties.Delegates

class TrackActivity : AppCompatActivity() {
    var id by Delegates.notNull<Int>()
    lateinit var name: String
    lateinit var categoryName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)
        handleExtras()
        setListFragment()
        handleBackButtonClick()
        handlePlayButtonClick()
    }

    private fun handleExtras() {
        id = intent.extras?.getInt("id") ?: 0
        name = intent.extras?.getString("name") ?: ""
        categoryName = intent.extras?.getString("categoryName") ?: ""

        findViewById<ImageView>(R.id.track_image).setImageResource(
            resources.getIdentifier(
                "track_${id}",
                "drawable",
                packageName
            )
        )

        findViewById<TextView>(R.id.track_name).text = name

        findViewById<TextView>(R.id.track_info).text = getString(
            R.string.track_info,
            intent.extras?.getInt("minutes"),
            categoryName
        )

        findViewById<TextView>(R.id.track_description).text =
            intent.extras?.getString("description")

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
            trackId = id ?: 0
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

    private fun handlePlayButtonClick() {
        findViewById<Button>(R.id.track_play_button).setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("name", name)
            intent.putExtra("categoryName", categoryName)
            startActivity(intent)
        }
    }
}