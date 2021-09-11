package com.example.sleep.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sleep.R
import com.example.sleep.sleep.SleepFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSleepFragment()
        setOnItemSelectedListener()
    }

    private fun setSleepFragment() {
        val fragment = SleepFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.menu_fragment_container, fragment)
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
                    false
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }
}