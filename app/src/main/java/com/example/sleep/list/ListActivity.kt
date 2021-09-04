package com.example.sleep.list

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.sleep.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListActivity : AppCompatActivity(R.layout.activity_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ListFragment>(R.id.list_container)
            }
        }

        setOnItemSelectedListener()
    }

    private fun setOnItemSelectedListener() {
        val menu = findViewById<BottomNavigationView>(R.id.menu)
        menu.itemIconTintList = null
        menu.selectedItemId = R.id.menu_sleep

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