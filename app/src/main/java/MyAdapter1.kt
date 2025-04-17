package com.example.juanfangidae

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter1(private val namalist: ArrayList<ItemData1>) :
    RecyclerView.Adapter<MyAdapter1.MyViewHolder>() {

        var onItemClick: ((ItemData1) -> Unit)? = null

    class MyViewHolder (itemdata: View) : RecyclerView.ViewHolder (itemdata) {
        val gambar : ImageView = itemdata.findViewById(R.id.img_logo)
        val judul  : TextView  = itemdata.findViewById(R.id.tv_judul)
        val penerbit  : TextView  = itemdata.findViewById(R.id.tv_penerbit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter1.MyViewHolder {
        val itemData1 = LayoutInflater.from(parent.context).inflate(R.layout.item_data
            ,parent, false)
        return com.example.juanfangidae.MyAdapter1.MyViewHolder(itemData1)
    }

    override fun getItemCount(): Int = namalist.size

    override fun onBindViewHolder(holder: MyAdapter1.MyViewHolder, position: Int) {
        val item = namalist[position]
        holder.gambar.setImageResource(item.gambar)
        holder.judul.text = item.judul
        holder.penerbit.text = item.penerbit

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }
}