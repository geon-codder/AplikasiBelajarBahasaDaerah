package com.example.AplBhsDaerah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.AplBhsDaerah.databinding.ActivityCompleteBioBinding
import com.example.AplBhsDaerah.game.GameActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CompleteBioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompleteBioBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompleteBioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFirebaseAuth()

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        binding.apply {

            btnSave.setOnClickListener {
                val user = Firebase.auth.currentUser?.email
                val nama = inputNama.text.toString()
                val nis = inputNIS.text.toString()
                val kelas = inputKelas.text.toString()
                val alamat = inputAlamat.text.toString()
                val sekolah = inputSekolah.text.toString()

                val dataSiswa = DataSiswa(user,nama, nis, kelas, alamat, sekolah)
                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("biodata")
                        .setValue(dataSiswa)
                }
                val intent = Intent(this@CompleteBioActivity, ProfilActivity::class.java)
                startActivity(intent)

            }
        }

    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }
}