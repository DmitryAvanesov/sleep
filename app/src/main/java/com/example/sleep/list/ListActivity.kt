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
        val fragment = ListFragment.newInstance(0)
        supportFragmentManager.beginTransaction()
            .replace(R.id.list_container, fragment)
            .commit()
    }

    private fun setOnItemSelectedListener() {
        val menu = findViewById<BottomNavigationView>(R.id.menu)

        menu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    true
                }
                R.id.menu_sleep -> {
                    true
                }
                R.id.menu_meditate -> {
                    true
                }
                R.id.menu_music -> {
                    true
                }
                R.id.menu_afsar -> {
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }
}