package com.example.AplBhsDaerah.home.sub.bab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityMenyimak5Binding
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Menyimak5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMenyimak5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenyimak5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            btnMenyimak5Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMenyimak5no1.text.toString()
                val jawaban2 = inputJawabanMenyimak5no2.text.toString()
                val jawaban3 = inputJawabanMenyimak5no3.text.toString()
                val jawaban4latin2 = inputJawabanMenyimak5no4latin2.text.toString()
                val jawaban4arti2 = inputJawabanMenyimak5no4arti2.text.toString()
                val jawaban4latin3 = inputJawabanMenyimak5no4latin3.text.toString()
                val jawaban4arti3 = inputJawabanMenyimak5no4arti3.text.toString()
                val jawaban4latin4 = inputJawabanMenyimak5no4latin4.text.toString()
                val jawaban4arti4 = inputJawabanMenyimak5no4arti4.text.toString()
                val jawaban4latin5 = inputJawabanMenyimak5no4latin5.text.toString()
                val jawaban4arti5 = inputJawabanMenyimak5no4arti5.text.toString()
                val jawaban4latin6 = inputJawabanMenyimak5no4latin6.text.toString()
                val jawaban4arti6 = inputJawabanMenyimak5no4arti6.text.toString()
                val jawaban4latin7 = inputJawabanMenyimak5no4latin7.text.toString()
                val jawaban4arti7 = inputJawabanMenyimak5no4arti7.text.toString()
                val jawaban4latin8 = inputJawabanMenyimak5no4latin8.text.toString()
                val jawaban4arti8 = inputJawabanMenyimak5no4arti8.text.toString()
                val jawaban4latin9 = inputJawabanMenyimak5no4latin9.text.toString()
                val jawaban4arti9 = inputJawabanMenyimak5no4arti9.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                val activityStatus = "done"

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin2")
                        .setValue(jawaban4latin2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti2")
                        .setValue(jawaban4arti2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin3")
                        .setValue(jawaban4latin3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti3")
                        .setValue(jawaban4arti3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin4")
                        .setValue(jawaban4latin4)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti4")
                        .setValue(jawaban4arti4)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin5")
                        .setValue(jawaban4latin5)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti5")
                        .setValue(jawaban4arti5)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin6")
                        .setValue(jawaban4latin6)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti6")
                        .setValue(jawaban4arti6)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin7")
                        .setValue(jawaban4latin7)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti7")
                        .setValue(jawaban4arti7)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin8")
                        .setValue(jawaban4latin8)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti8")
                        .setValue(jawaban4arti8)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4latin9")
                        .setValue(jawaban4latin9)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menyimak4arti9")
                        .setValue(jawaban4arti9)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menyimak5").setValue(activityStatus)
                }
                val intent = Intent(this@Menyimak5Activity, SubBab5Activity::class.java)
                startActivity(intent)
            }
        }
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }
}