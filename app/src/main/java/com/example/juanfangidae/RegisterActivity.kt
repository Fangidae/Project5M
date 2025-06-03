package com.example.juanfangidae

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.juanfangidae.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.cbShowPassword2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Tampilkan password untuk kedua field
                binding.etPass2.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.etPass3.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                // Sembunyikan password (tampilkan sebagai bintang) untuk kedua field
                binding.etPass2.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.etPass3.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            // Pastikan cursor tetap di akhir teks di kedua EditText
            binding.etPass2.setSelection(binding.etPass2.text.length)
            binding.etPass3.setSelection(binding.etPass3.text.length)
        }

        binding.textLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail2.text.toString().trim()
            val password = binding.etPass2.text.toString().trim()
            val konfirmasiPassword = binding.etPass3.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail2.error = "Email tidak boleh kosong"
                binding.etEmail2.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail2.error = "Format email tidak valid"
                binding.etEmail2.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPass2.error = "Password tidak boleh kosong"
                binding.etPass2.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.etPass2.error = "Password minimal 6 karakter"
                binding.etPass2.requestFocus()
                return@setOnClickListener
            }

            if (konfirmasiPassword.isEmpty()) {
                binding.etPass3.error = "Konfirmasi password tidak boleh kosong"
                binding.etPass3.requestFocus()
                return@setOnClickListener
            }

            if (password != konfirmasiPassword) {
                binding.etPass3.error = "Konfirmasi password tidak cocok"
                binding.etPass3.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)
        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Registrasi berhasil, silakan login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Registrasi gagal: ${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
