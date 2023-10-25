package com.izzzya.gnomesclicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izzzya.gnomesclicker.adapter.DataSource
import com.izzzya.gnomesclicker.adapter.ExtentAdapter
import com.izzzya.gnomesclicker.adapter.GnomesAdapter
import com.izzzya.gnomesclicker.classes.SharedPrefs

class StoreFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moneys = view.findViewById<TextView>(R.id.moneysTV)
        val settings = view.findViewById<ImageButton>(R.id.settingsBtn)
        val exit = view.findViewById<ImageButton>(R.id.exitBtn)

        moneys.text = SharedPrefs.getMoney().toString() + getString(R.string.dollar)

        settings.setOnClickListener {
            findNavController().navigate(R.id.action_global_settingsFragment)
        }
        exit.setOnClickListener {
            findNavController().popBackStack()
        }

        val RV_e = view.findViewById<RecyclerView>(R.id.multipliersRV)
        val llm = LinearLayoutManager(requireContext(), )
        llm.orientation = LinearLayoutManager.VERTICAL
        RV_e.layoutManager = llm
        RV_e.setHasFixedSize(true)
        RV_e.adapter = ExtentAdapter(requireContext(), DataSource.extList)

        val RV_g = view.findViewById<RecyclerView>(R.id.skinsRV)
        val llm1 = LinearLayoutManager(requireContext(), )
        llm1.orientation = LinearLayoutManager.VERTICAL
        RV_g.layoutManager = llm1
        RV_g.setHasFixedSize(true)
        RV_g.adapter = GnomesAdapter(requireContext(), DataSource.skinsList)

    }

}