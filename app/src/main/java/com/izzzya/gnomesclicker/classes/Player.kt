package com.izzzya.gnomesclicker.classes

import android.content.Context
import android.media.MediaPlayer
import com.izzzya.gnomesclicker.R

class Player(context: Context) {

    init {
        player = MediaPlayer.create(context, R.raw.synthwave_lutiy)
        sound = MediaPlayer.create(context, R.raw.click)

    }

    companion object{
        var player: MediaPlayer? = null
        var sound: MediaPlayer? = null

        fun musicPlay(){
            if (SharedPrefs.getMusic()){
            player?.start()
            }
        }

        fun musicPause(){
            player?.pause()
        }

        fun soundPlay(){
            if (SharedPrefs.getSound()){
                sound?.start()
            }
        }
    }
}