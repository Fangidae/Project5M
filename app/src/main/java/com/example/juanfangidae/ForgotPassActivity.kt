package com.example.juanfangidae

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ForgotPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_pass)

        val etReset = findViewById<EditText>(R.id.et_reset)
        val btnReset = findViewById<Button>(R.id.btn_reset)

        btnReset.setOnClickListener {
            val emailInput = etReset.text.toString().trim()
            if (emailInput.isNotEmpty()) {
                Toast.makeText(this, "Code verifikasi telah dikirim ke Email anda.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Email belum diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}