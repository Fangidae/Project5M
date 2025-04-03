package com.example.juanfangidae

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BerandaActivity : AppCompatActivity() {

    private lateinit var perpustakaanRecyclerView: RecyclerView
    private lateinit var perpustakaanAdapter: MyAdapter
    private lateinit var listPerpustakaan : ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        perpustakaanRecyclerView = findViewById(R.id.perpustakaanRv)
        listPerpustakaan = ArrayList()

        listPerpustakaan.add(ItemData(R.drawable.buku, "Biologi SMA/MA", "Esis"))
        listPerpustakaan.add(ItemData(R.drawable.bukuii, "Laskar Pelangi", "Bentang Pustaka"))
        listPerpustakaan.add(ItemData(R.drawable.bukuiii, "Negara & Revolusi", "Resist Book"))
        listPerpustakaan.add(ItemData(R.drawable.bukuiv, "Rich Dad Poor Dad", "Warner Books"))
        listPerpustakaan.add(ItemData(R.drawable.bukuv, "Artificial Intelligence", "Pearson"))
        listPerpustakaan.add(ItemData(R.drawable.bukuvi, "Hukum Pidana", "Bumi Aksara"))

        perpustakaanRecyclerView.layoutManager = LinearLayoutManager(this)
        perpustakaanRecyclerView.setHasFixedSize(true)
        perpustakaanAdapter = MyAdapter(listPerpustakaan)
        perpustakaanRecyclerView.adapter = perpustakaanAdapter
    }
}