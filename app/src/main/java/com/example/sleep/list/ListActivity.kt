package com.example.sleep.list

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.sleep.R
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


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