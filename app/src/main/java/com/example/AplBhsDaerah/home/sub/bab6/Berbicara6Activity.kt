package com.example.AplBhsDaerah.home.sub.bab6

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityBerbicara6Binding
import com.example.AplBhsDaerah.home.sub.SubBab6Activity
import com.example.AplBhsDaerah.home.sub.bab4.Berbicara4Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Berbicara6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityBerbicara6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerbicara6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            btnBerbicara6pilgan1a.setOnClickListener {
                btnBerbicara6pilgan1a.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan1b.setOnClickListener {
                btnBerbicara6pilgan1b.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Berbicara6Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnBerbicara6pilgan1c.setOnClickListener {
                btnBerbicara6pilgan1c.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan1d.setOnClickListener {
                btnBerbicara6pilgan1d.setBackgroundColor(Color.RED)
            }

            btnBerbicara6pilgan2a.setOnClickListener {
                btnBerbicara6pilgan2a.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Berbicara6Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnBerbicara6pilgan2b.setOnClickListener {
                btnBerbicara6pilgan2b.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan2c.setOnClickListener {
                btnBerbicara6pilgan2c.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan2d.setOnClickListener {
                btnBerbicara6pilgan2d.setBackgroundColor(Color.RED)
            }

            btnBerbicara6pilgan3a.setOnClickListener {
                btnBerbicara6pilgan3a.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan3b.setOnClickListener {
                btnBerbicara6pilgan3b.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan3c.setOnClickListener {
                btnBerbicara6pilgan3c.setBackgroundColor(Color.RED)
            }
            btnBerbicara6pilgan3d.setOnClickListener {
                btnBerbicara6pilgan3d.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Berbicara6Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()

            }

            btnBerbicara6Selesai.setOnClickListener {
                val jawaban1 = inputJawabanBerbicara6no1.text.toString()
                val jawaban2 = inputJawabanBerbicara6no2.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor
                val activityStatus = "done"

                val skorBerbicara6 = pref.getInt("berbicara6", 0)
                if (skorBerbicara6 == 0){
                    editor.putInt("berbicara6", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Berbicara6Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("berbicara1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("berbicara2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara6").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("berbicara6").setValue(activityStatus)
                }

                val intent = Intent(this@Berbicara6Activity, SubBab6Activity::class.java)
                startActivity(intent)
            }
        }
    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }
    companion object{
        var skor = 0
    }
}