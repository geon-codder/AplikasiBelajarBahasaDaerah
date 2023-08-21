package com.example.AplBhsDaerah.home.sub.bab4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.databinding.ActivityMenulis4Binding
import com.example.AplBhsDaerah.home.sub.SubBab4Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Menulis4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMenulis4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenulis4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {

            btnMenulis4pilgan1a.setOnClickListener {
                btnMenulis4pilgan1a.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan1b.setOnClickListener {
                btnMenulis4pilgan1b.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan1c.setOnClickListener {
                btnMenulis4pilgan1c.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan1d.setOnClickListener {
                btnMenulis4pilgan1d.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Menulis4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }


            btnMenulis4pilgan2a.setOnClickListener {
                btnMenulis4pilgan2a.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan2b.setOnClickListener {
                btnMenulis4pilgan2b.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Menulis4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnMenulis4pilgan2c.setOnClickListener {
                btnMenulis4pilgan2c.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan2d.setOnClickListener {
                btnMenulis4pilgan2d.setBackgroundColor(Color.RED)
            }

            btnMenulis4pilgan3a.setOnClickListener {
                btnMenulis4pilgan3a.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Menulis4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnMenulis4pilgan3b.setOnClickListener {
                btnMenulis4pilgan3b.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan3c.setOnClickListener {
                btnMenulis4pilgan3c.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan3d.setOnClickListener {
                btnMenulis4pilgan3d.setBackgroundColor(Color.RED)
            }

            btnMenulis4pilgan4a.setOnClickListener {
                btnMenulis4pilgan4a.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan4b.setOnClickListener {
                btnMenulis4pilgan4b.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Menulis4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnMenulis4pilgan4c.setOnClickListener {
                btnMenulis4pilgan4c.setBackgroundColor(Color.RED)
            }
            btnMenulis4pilgan4d.setOnClickListener {
                btnMenulis4pilgan4d.setBackgroundColor(Color.RED)
            }

            btnMenulis4Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMenulis4no1.text.toString()
                val jawaban2 = inputJawabanMenulis4no2.text.toString()
                val jawaban3a = inputJawabanMenulis4no3a.text.toString()
                val jawaban3b = inputJawabanMenulis4no3b.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor
                val activityStatus = "done"

                val skorMenulis4 = pref.getInt("menulis4", 0)
                if(skorMenulis4 == 0){
                    editor.putInt("menulis4", skorAkhir)
                    editor.apply()

                    Toast.makeText(this@Menulis4Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1a")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1b")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1c")
                        .setValue(jawaban3a)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1d")
                        .setValue(jawaban3b)
//                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").get().addOnSuccessListener {
//                        if (it.exists()){
//                            val skorAwal = it.child("skor").value.toString().toInt()
//                            val skorAkhir = skorAwal + skor
//                            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").setValue(skorAkhir)
//                        }
//                    }
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis4").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menulis4").setValue(activityStatus)

                }
                val intent = Intent(this@Menulis4Activity, SubBab4Activity::class.java)
                startActivity(intent)
            }
        }
    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    companion object {
        var skor = 0
    }
}