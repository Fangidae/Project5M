package com.example.juanfangidae

import android.annotation.SuppressLint
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class DetailActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var btnSpeak: ImageButton
    private lateinit var deskripsi: String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val gambar: ImageView = findViewById(R.id.img1)
        val judul: TextView = findViewById(R.id.txt1)
        val descripsi: TextView = findViewById(R.id.txt2)

        // Ambil data dari Intent
        val data = intent.getParcelableExtra<ItemData1>("item")

        // Periksa apakah data tidak null
        data?.let {
            gambar.setImageResource(it.gambar)
            judul.text = it.judul
            descripsi.text = it.deskripsi

            // Set deskripsi untuk dibaca
            deskripsi = it.deskripsi
        }

        // Inisialisasi tombol bicara
        btnSpeak = findViewById(R.id.btn_speak)
        btnSpeak.setOnClickListener {
            speakDescription()
        }

        // Inisialisasi TextToSpeech
        tts = TextToSpeech(this, this)
    }

    private fun speakDescription() {
        if (::tts.isInitialized) {
            tts.speak(deskripsi, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            Toast.makeText(this, "TTS belum siap.", Toast.LENGTH_SHORT).show()
        }
    }

    // Callback untuk inisialisasi TTS
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("id", "ID") // Bahasa Indonesia
        } else {
            Toast.makeText(this, "TextToSpeech gagal diinisialisasi.", Toast.LENGTH_SHORT).show()
        }
    }

    // Bersihkan sumber daya TTS saat activity dihancurkan
    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}
