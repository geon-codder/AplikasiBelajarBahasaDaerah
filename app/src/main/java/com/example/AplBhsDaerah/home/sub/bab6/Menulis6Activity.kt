package com.example.AplBhsDaerah.home.sub.bab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityMenulis6Binding
import com.example.AplBhsDaerah.home.sub.SubBab6Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Menulis6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMenulis6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenulis6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            btnMenulis6Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMenulis6no1.text.toString()
                val jawaban2 = inputJawabanMenulis6no2.text.toString()
                val jawaban3 = inputJawabanMenulis6no3.text.toString()
                val jawaban4 = inputJawabanMenulis6no4.text.toString()
                val jawaban5 = inputJawabanMenulis6no5.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                val activityStatus = "done"

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menulis1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menulis2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menulis3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menulis4")
                        .setValue(jawaban4)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menulis5")
                        .setValue(jawaban5)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menulis6").setValue(activityStatus)
                }

                val intent = Intent(this@Menulis6Activity, SubBab6Activity::class.java)
                startActivity(intent)
            }
        }
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }
}