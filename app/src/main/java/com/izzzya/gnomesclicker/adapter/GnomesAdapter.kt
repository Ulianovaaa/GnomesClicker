package com.izzzya.gnomesclicker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.izzzya.gnomesclicker.R
import com.izzzya.gnomesclicker.classes.SharedPrefs

class GnomesAdapter(private val context: Context?,
                    private val dataset: List<Skin>
): RecyclerView.Adapter<GnomesAdapter.GnomeViewHolder>() {

    class GnomeViewHolder(view: View): RecyclerView.ViewHolder(view!!){
        val img = view.findViewById<ImageView>(R.id.gnomeImg)
        val cost = view.findViewById<TextView>(R.id.costTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GnomeViewHolder {
        val mLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.gnome_item, parent, false)
        return GnomeViewHolder(mLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: GnomeViewHolder, position: Int) {
        val item = dataset[position]

        holder.img.setImageResource(item.img)
        holder.cost.text = item.cost.toString()+context!!.getString(R.string.dollar)
        if (item.id> SharedPrefs.getGnome()+1){
            holder.itemView.alpha = 0.7f
        }else{
            holder.itemView.setOnClickListener {
                if (SharedPrefs.getMoney() - item.cost >=0 && (item.id> SharedPrefs.getGnome())){
                    val money = SharedPrefs.getMoney() - item.cost
                    SharedPrefs.setMoney(money)
                    SharedPrefs.setGnome(item.id)
                }else{
                    Toast.makeText(context!!, "Not available!", Toast.LENGTH_SHORT).show()
                }
            }
        }    }
}