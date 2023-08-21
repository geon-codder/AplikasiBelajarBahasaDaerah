package com.example.AplBhsDaerah.game

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.AplBhsDaerah.databinding.ActivityGameBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFirebaseAuth()

        binding.apply {

            btnSkorBerbicara4.setOnClickListener {
                val database = FirebaseDatabase.getInstance()
                val myRef = database.getReference("dataUser")
                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara4").get().addOnSuccessListener {
                        if (it.exists()){
                            var skorberbicara4 = it.value.toString().toInt()
                            Toast.makeText(this@GameActivity, "$skorberbicara4", Toast.LENGTH_SHORT).show()
                            skorberbicara4 += 10
                            skorberbicara4 += 10
                            Toast.makeText(this@GameActivity, "$skorberbicara4 setelah ditambah 20", Toast.LENGTH_SHORT).show()
                            berbicara4 = skorberbicara4
                        }
                    }
                }
            }
            btnSkormembaca4.setOnClickListener {
                val database = FirebaseDatabase.getInstance()
                val myRef = database.getReference("dataUser")
                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("membaca4").get().addOnSuccessListener {
                        if (it.exists()){
                            var skorberbicara4 = it.value.toString().toInt()
                            Toast.makeText(this@GameActivity, "$skorberbicara4", Toast.LENGTH_SHORT).show()
                            skorberbicara4 += 10
                            skorberbicara4 += 10
                            Toast.makeText(this@GameActivity, "$skorberbicara4 setelah ditambah 20", Toast.LENGTH_SHORT).show()
                            membaca4 = skorberbicara4
                        }
                    }
                }
            }
            btnSkormenulis4.setOnClickListener {
                val database = FirebaseDatabase.getInstance()
                val myRef = database.getReference("dataUser")
                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis4").get().addOnSuccessListener {
                        if (it.exists()){
                            var skorberbicara4 = it.value.toString().toInt()
                            Toast.makeText(this@GameActivity, "$skorberbicara4", Toast.LENGTH_SHORT).show()
                            skorberbicara4 += 10
                            skorberbicara4 += 10
                            Toast.makeText(this@GameActivity, "$skorberbicara4 setelah ditambah 20", Toast.LENGTH_SHORT).show()
                            menulis4 = skorberbicara4
                        }
                    }
                }
            }
//                .child(encodeUserEmail(getUserEmail).toString())
//            .currentUser?.email.toString()
            btnSkorTotal.setOnClickListener {
                cekSkorBerbicara4()
//                val database = FirebaseDatabase.getInstance()
//                val myRef = database.getReference("dataUser")
//                val getUserEmail = Firebase.auth.currentUser?.email.toString()
//                val skorAkhir = 100
//                myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis4").setValue(skorAkhir)

            }
        }
    }

    private fun cekSkorBerbicara4(){
        val totalSkor = puzzlebab4 + menyimak4 + berbicara4 + membaca4 + menulis4
        Toast.makeText(this@GameActivity, "Total skor : $totalSkor", Toast.LENGTH_SHORT).show()
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }

    fun encodeUserEmail(userEmail: String): String {
        return userEmail.replace(".", ",")
    }

    fun decodeUserEmail(userEmail: String): String {
        return userEmail.replace(",", ".")
    }

    companion object{
        var puzzlebab4 = 0
        var berbicara4 = 0
        var menyimak4 = 0
        var membaca4 = 0
        var menulis4 = 0
    }

}