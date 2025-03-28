package com.example.juanfangidae

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.juanfangidae.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val name     = binding.etUsername.text.toString().trim()
            val email    = binding.etEmail2.text.toString().trim()
            val password = binding.etPass2.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Registrasi Berhasil!!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("USERNAME", name)
                startActivity(intent)
                finish()
        }   else {
            Toast.makeText(this, "Harap diisi semuanya!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}