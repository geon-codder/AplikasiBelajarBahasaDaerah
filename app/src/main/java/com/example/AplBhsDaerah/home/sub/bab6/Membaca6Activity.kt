package com.example.AplBhsDaerah.home.sub.bab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityMembaca6Binding
import com.example.AplBhsDaerah.home.sub.SubBab6Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Membaca6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMembaca6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMembaca6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            btnMembaca6Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMembaca6no1.text.toString()
                val jawaban2 = inputJawabannMembaca6no2.text.toString()
                val jawaban3 = inputJawabannMembaca6no3.text.toString()
                val jawaban4 = inputJawabannMembaca6no4.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                val activityStatus = "done"

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("membaca1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("membaca2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("membaca3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("membaca4")
                        .setValue(jawaban4)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("membaca6").setValue(activityStatus)
                }

                val intent = Intent(this@Membaca6Activity, SubBab6Activity::class.java)
                startActivity(intent)
            }
        }

    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }
}