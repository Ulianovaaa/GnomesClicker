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

class ExtentAdapter(private val context: Context?,
                    private val dataset: List<Extentention>
): RecyclerView.Adapter<ExtentAdapter.ExtViewHolder>() {

    class ExtViewHolder(view: View): RecyclerView.ViewHolder(view!!){
        val img = view.findViewById<ImageView>(R.id.arrow)
        val cost = view.findViewById<TextView>(R.id.costTV)
        val multip = view.findViewById<TextView>(R.id.multipTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtViewHolder {
        val mLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.ext_item, parent, false)
        return ExtViewHolder(mLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ExtViewHolder, position: Int) {
        val item = dataset[position]

        holder.img.setImageResource(item.img)
        holder.cost.text = item.cost.toString()+context!!.getString(R.string.dollar)
        holder.multip.text = context!!.getString(R.string.x) + item.value
        if (item.id> SharedPrefs.getMultip()+1){
            holder.itemView.alpha = 0.7f
        }else{
            holder.itemView.setOnClickListener {
                if (SharedPrefs.getMoney() - item.cost >=0 && (item.id>SharedPrefs.getMultip())){
                    val money = SharedPrefs.getMoney() - item.cost
                    SharedPrefs.setMoney(money)
                    SharedPrefs.setMultip(item.id)
                }else{
                    Toast.makeText(context!!, "Not available!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}