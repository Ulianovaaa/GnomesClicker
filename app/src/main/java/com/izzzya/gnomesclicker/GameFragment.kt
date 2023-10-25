package com.izzzya.gnomesclicker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.izzzya.gnomesclicker.adapter.DataSource
import com.izzzya.gnomesclicker.classes.SharedPrefs

class GameFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gnome = view.findViewById<ImageView>(R.id.gnomeIV)
        val moneys = view.findViewById<TextView>(R.id.moneyTV)
        val clickTV =view.findViewById<TextView>(R.id.clickTV)
        var money = SharedPrefs.getMoney()
        val click_cost = if (SharedPrefs.getMultip()>0){
            2*(SharedPrefs.getMultip()+1)
        }else{
            2
        }
        clickTV.text = "+$click_cost"
        gnome.setImageResource(DataSource.skinsList[SharedPrefs.getGnome()].img)
        moneys.text = SharedPrefs.getMoney().toString() + getString(R.string.dollar)

        view.findViewById<ImageButton>(R.id.settingsBtn).setOnClickListener {
            findNavController().navigate(R.id.action_global_settingsFragment)
        }
        view.findViewById<ImageButton>(R.id.shopBtn).setOnClickListener {
            findNavController().navigate(R.id.action_global_storeFragment)
        }

        view.setOnClickListener {
            when(gnome.rotation){
                5f -> gnome.rotation = -5f
                -5f -> gnome.rotation = 5f
            }
            clickTV.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.fade_slide_up))
            money+=click_cost
//            Log.i("MONEYS: ", money.toString())
            SharedPrefs.setMoney(money)
//            Log.i("MONEYS sp: ", SharedPrefs.getMoney().toString())
            moneys.text = SharedPrefs.getMoney().toString() + getString(R.string.dollar)
        }
    }


}