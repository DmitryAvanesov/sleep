package com.example.sleep.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.sleep.R
import com.example.sleep.list.ListActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        handleExtras()
        handleBackButtonClick()
    }

    private fun handleExtras() {
        findViewById<TextView>(R.id.category_title).text = getString(
            R.string.category_title,
            intent.extras?.get("name")
        )
    }

    private fun handleBackButtonClick() {
        findViewById<ImageButton>(R.id.category_back_button).setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}