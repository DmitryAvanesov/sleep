package com.example.sleep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sleep.menu.MenuActivity
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

}