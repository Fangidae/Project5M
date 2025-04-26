package com.example.juanfangidae

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.juanfangidae.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private var selectedImageUri: Uri? = null

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPilihGambar.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        binding.btnSimpan.setOnClickListener {
            val email = binding.etEmailEdit.text.toString().trim()
            val nama = binding.etNamaEdit.text.toString().trim()

            if (email.isNotEmpty() && nama.isNotEmpty()) {
                val sharedPref = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("email", email)
                    putString("nama", nama)
                    selectedImageUri?.let { uri ->
                        putString("gambar", uri.toString())
                    }
                    apply()
                }

                Toast.makeText(this, "", Toast.LENGTH_SHORT)

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            if (selectedImageUri != null) {
                try {
                    // Ambil persistable URI permission
                    contentResolver.takePersistableUriPermission(
                        selectedImageUri!!,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION
                    )
                } catch (e: SecurityException) {
                    Toast.makeText(this, "", Toast.LENGTH_SHORT)
                }

                binding.imgProfile2.setImageURI(selectedImageUri)
            }
        }
    }
}
