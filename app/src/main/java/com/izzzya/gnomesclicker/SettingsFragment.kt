package com.izzzya.gnomesclicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.izzzya.gnomesclicker.classes.Player
import com.izzzya.gnomesclicker.classes.SharedPrefs

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sound = view.findViewById<ImageButton>(R.id.soundBtn)
        val music  = view.findViewById<ImageButton>(R.id.musicBtn)
        val exit = view.findViewById<ImageButton>(R.id.xBtn)

        exit.setOnClickListener {
            findNavController().popBackStack()
        }

        fun checkAlphas(){
            if (SharedPrefs.getSound()){
                sound.alpha = 1f
            }else {
                sound.alpha = 0.7f
            }
            if (SharedPrefs.getMusic()){
                music.alpha = 1f
            }else {
                music.alpha = 0.7f
            }
        }

        checkAlphas()

        sound.setOnClickListener {
            if (SharedPrefs.getSound()){
                SharedPrefs.setSound(false)
            }else {
                SharedPrefs.setSound(true)
            }
            checkAlphas()
        }

        music.setOnClickListener {
            if (SharedPrefs.getMusic()){
                Player.musicPause()
                SharedPrefs.setMusic(false)
            }else {
                SharedPrefs.setMusic(true)
                Player.musicPlay()
            }
            checkAlphas()
        }
    }

}