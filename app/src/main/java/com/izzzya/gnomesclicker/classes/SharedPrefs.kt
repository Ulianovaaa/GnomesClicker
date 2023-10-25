package com.izzzya.gnomesclicker.classes

import android.content.Context
import android.content.SharedPreferences
import com.izzzya.gnomesclicker.R

class SharedPrefs(context: Context) {
    init {
        sharedPref = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    }

    companion object{
        private var sharedPref: SharedPreferences? = null
        const val PREFERENCES = "prefs"
        const val MUSIC = true
        const val SOUND = true
        const val MONEY = 0
        const val MULTIPLYER_ID = 0
        val GNOME_SKIN_ID: Int = 0
        var SCORE = 0


        fun setMusic(m: Boolean){
            sharedPref?.edit()
                ?.putBoolean("MUSIC", m)
                ?.apply()
        }

        fun getMusic(): Boolean{
            return sharedPref!!.getBoolean("MUSIC", true)
        }


        fun setSound(m: Boolean){
            sharedPref?.edit()
                ?.putBoolean("SOUND", m)
                ?.apply()
        }

        fun getSound(): Boolean{
            return sharedPref!!.getBoolean("SOUND", true)
        }


        fun setMoney(m: Int){
            sharedPref?.edit()
                ?.putInt("MONEY", m)
                ?.apply()
        }

        fun getMoney(): Int{
            return sharedPref!!.getInt("MONEY", 0)
        }

        fun setGnome(m: Int){
            sharedPref?.edit()
                ?.putInt("GNOME_SKIN_ID", m)
                ?.apply()
        }

        fun getGnome(): Int{
            return sharedPref!!.getInt("GNOME_SKIN_ID", 0)
        }

        fun setMultip(m: Int){
            sharedPref?.edit()
                ?.putInt("MULTIPLYER_ID", m)
                ?.apply()
        }

        fun getMultip(): Int{
            return sharedPref!!.getInt("MULTIPLYER_ID", 0)
        }
    }
}