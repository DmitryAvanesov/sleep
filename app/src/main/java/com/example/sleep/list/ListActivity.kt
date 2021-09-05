package com.example.sleep.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListActivity : AppCompatActivity(R.layout.activity_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListFragment()
        setOnItemSelectedListener()
    }

    private fun setListFragment() {
        val fragment = ListFragment.newInstance(categoryId = 0, trackId = 0)
        supportFragmentManager.beginTransaction()
            .replace(R.id.list_container, fragment)
            .commit()
    }

    private fun setOnItemSelectedListener() {
        val menu = findViewById<BottomNavigationView>(R.id.menu)
        menu.itemIconTintList = null
        menu.selectedItemId = R.id.menu_sleep

        menu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    false
                }
                R.id.menu_sleep -> {
                    true
                }
                R.id.menu_meditate -> {
                    false
                }
                R.id.menu_music -> {
                    false
                }
                R.id.menu_author -> {
<<<<<<< HEAD
                    true
=======
                    false
>>>>>>> ea63680 (Restricted bottom menu transitions)
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }
}