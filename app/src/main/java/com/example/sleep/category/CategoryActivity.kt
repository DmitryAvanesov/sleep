package com.example.sleep.category

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sleep.R
import com.example.sleep.sleep.ListFragment

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        handleExtras()
        setListFragment()
        handleBackButtonClick()
    }

    private fun handleExtras() {
        findViewById<TextView>(R.id.category_title).text = getString(
            R.string.category_title,
            intent.extras?.get("name")
        )
    }

    private fun setListFragment() {
        val fragment =
            intent.extras?.let {
                ListFragment.newInstance(
                    categoryId = it.getInt("id"),
                    trackId = 0
                )
            } as Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.category_list_container, fragment)
            .commit()
    }

    private fun handleBackButtonClick() {
        findViewById<ImageButton>(R.id.category_back_button).setOnClickListener {
            finish()
        }
    }
}