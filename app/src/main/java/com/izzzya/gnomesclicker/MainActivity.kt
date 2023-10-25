package com.izzzya.gnomesclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.izzzya.gnomesclicker.classes.Player
import com.izzzya.gnomesclicker.classes.SharedPrefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPrefs(this)
        Player(this)
        setContentView(R.layout.activity_main)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onPause() {
        super.onPause()
        Player.musicPause()
    }

    override fun onResume() {
        super.onResume()
        Player.musicPlay()
    }
}