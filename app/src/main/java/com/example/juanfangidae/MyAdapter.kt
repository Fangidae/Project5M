package com.example.juanfangidae

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val namalist: ArrayList<ItemData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        class MyViewHolder (itemdata: View) : RecyclerView.ViewHolder (itemdata) {
            val gambar : ImageView = itemdata.findViewById(R.id.img_logo)
            val judul  : TextView  = itemdata.findViewById(R.id.tv_judul)
            val penerbit  : TextView  = itemdata.findViewById(R.id.tv_penerbit)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data
        ,parent, false)
        return MyViewHolder(itemData)
    }

    override fun getItemCount(): Int = namalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namalist[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.judul.text = currentItem.judul
        holder.penerbit.text = currentItem.penerbit
    }

}