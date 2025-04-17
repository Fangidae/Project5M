package com.example.juanfangidae

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.juanfangidae.ItemData1
import com.example.juanfangidae.R

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val gambar: ImageView = findViewById(R.id.img1)
        val judul: TextView = findViewById(R.id.txt1)
        val descripsi: TextView = findViewById(R.id.txt2)


        val data = intent.getParcelableExtra<ItemData1>("item")

        data?.let{
            gambar.setImageResource(it.gambar)
            judul.text = it.judul
            descripsi.text = it.deskripsi
        }
    }
}