package com.example.AplBhsDaerah.home.sub.bab4

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.AplBhsDaerah.databinding.ActivityBerbicara4Binding
import com.example.AplBhsDaerah.home.sub.SubBab4Activity
import com.example.AplBhsDaerah.home.sub.bab6.Berbicara6Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Berbicara4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityBerbicara4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerbicara4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        binding.apply {

            btnBerbicara4pilgan1a.setOnClickListener {
                btnBerbicara4pilgan1a.setBackgroundColor(Color.RED)
            }
            btnBerbicara4pilgan1b.setOnClickListener {
                btnBerbicara4pilgan1b.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Berbicara4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnBerbicara4pilgan1c.setOnClickListener {
                btnBerbicara4pilgan1c.setBackgroundColor(Color.RED)
            }
            btnBerbicara4pilgan1d.setOnClickListener {
                btnBerbicara4pilgan1d.setBackgroundColor(Color.RED)
            }

            btnBerbicara4pilgan2a.setOnClickListener {
                btnBerbicara4pilgan2a.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Berbicara4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnBerbicara4pilgan2b.setOnClickListener {
                btnBerbicara4pilgan2b.setBackgroundColor(Color.RED)
            }
            btnBerbicara4pilgan2c.setOnClickListener {
                btnBerbicara4pilgan2c.setBackgroundColor(Color.RED)
            }
            btnBerbicara4pilgan2d.setOnClickListener {
                btnBerbicara4pilgan2d.setBackgroundColor(Color.RED)
            }

            btnBerbicara4pilgan3a.setOnClickListener {
                btnBerbicara4pilgan3a.setBackgroundColor(Color.RED)
            }
            btnBerbicara4pilgan3b.setOnClickListener {
                btnBerbicara4pilgan3b.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Berbicara4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnBerbicara4pilgan3c.setOnClickListener {
                btnBerbicara4pilgan3c.setBackgroundColor(Color.RED)
            }
            btnBerbicara4pilgan3d.setOnClickListener {
                btnBerbicara4pilgan3d.setBackgroundColor(Color.RED)
            }

            btnBerbicara4Selesai.setOnClickListener {
                val jawaban1 = inputJawabanBerbicara4no1.text.toString()
                val jawaban2 = inputJawabanBerbicara4no2.text.toString()
                val jawaban3 = inputJawabanBerbicara4no3.text.toString()
                val jawaban3a = inputJawabanBerbicara4no3a.text.toString()
                val jawaban3b = inputJawabanBerbicara4no3b.text.toString()
                val jawaban3c = inputJawabanBerbicara4no3c.text.toString()
                val jawaban4a = inputJawabanBerbicara4no4a.text.toString()
                val jawaban4b = inputJawabanBerbicara4no4b.text.toString()
                val jawaban4c = inputJawabanBerbicara4no4c.text.toString()
                val jawaban4d = inputJawabanBerbicara4no4d.text.toString()
                val jawaban4e = inputJawabanBerbicara4no4e.text.toString()
                val jawaban4f = inputJawabanBerbicara4no4f.text.toString()


                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor

                val activityStatus = "done"

                val skorBerbicara4 = pref.getInt("berbicara4", 0)
                if(skorBerbicara4 == 0){
                    editor.putInt("berbicara4", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Berbicara4Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }


                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara3a")
                        .setValue(jawaban3a)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara3b")
                        .setValue(jawaban3b)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara3c")
                        .setValue(jawaban3c)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara4a")
                        .setValue(jawaban4a)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara4b")
                        .setValue(jawaban4b)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara4c")
                        .setValue(jawaban4c)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara4d")
                        .setValue(jawaban4d)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara4e")
                        .setValue(jawaban4e)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("berbicara4f")
                        .setValue(jawaban4f)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara4").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("berbicara4").setValue(activityStatus)

                }
                skor = 0
                val intent = Intent(this@Berbicara4Activity, SubBab4Activity::class.java)
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