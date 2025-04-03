package com.example.juanfangidae

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.juanfangidae.databinding.ActivityLoginBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //klik login
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPass.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login Berhasil!!", Toast.LENGTH_SHORT).show()

                //pindah ke halaman dashboard
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("EMAIL", email)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi Semua!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}