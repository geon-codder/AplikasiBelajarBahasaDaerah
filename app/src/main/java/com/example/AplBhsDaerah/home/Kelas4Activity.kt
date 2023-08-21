package com.example.AplBhsDaerah.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.AplBhsDaerah.databinding.ActivityKelas4Binding
import com.example.AplBhsDaerah.home.sub.SubBab4Activity
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.example.AplBhsDaerah.home.sub.SubBab6Activity
import com.example.AplBhsDaerah.newfeature.PuzzleBab4Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Kelas4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityKelas4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelas4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "Kelas 4"
        display?.setDisplayHomeAsUpEnabled(true)

        cekActivityComplete()

        binding.apply {

            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("dataUser")
            val getUserEmail = Firebase.auth.currentUser?.email.toString()

            btnKlsToBab4.setOnClickListener {
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab4").get()
                        .addOnSuccessListener {
                            val donechecker = it.value.toString()
                            if (donechecker == "done") {
                                val intent = Intent(this@Kelas4Activity, SubBab4Activity::class.java)
                                startActivity(intent)
                            } else{
                                val intent = Intent(this@Kelas4Activity, PuzzleBab4Activity::class.java)
                                intent.putExtra("assetName", "puzzlebab4.png")
                                startActivity(intent)
                            }
                        }
                }
            }
            btnKlsToBab5.setOnClickListener {
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab5").get()
                        .addOnSuccessListener {
                            val donechecker = it.value.toString()
                            if (donechecker == "done") {
                                val intent = Intent(this@Kelas4Activity, SubBab5Activity::class.java)
                                startActivity(intent)
                            } else{
                                val intent = Intent(this@Kelas4Activity, PuzzleBab4Activity::class.java)
                                intent.putExtra("assetName", "puzzlebab5.png")
                                startActivity(intent)
                            }


                        }
                }
            }
            btnKlsToBab6.setOnClickListener {
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab6").get()
                        .addOnSuccessListener {
                            val donechecker = it.value.toString()
                            if (donechecker == "done") {
                                val intent = Intent(this@Kelas4Activity, SubBab6Activity::class.java)
                                startActivity(intent)
                            } else{
                                val intent = Intent(this@Kelas4Activity, PuzzleBab4Activity::class.java)
                                intent.putExtra("assetName", "puzzlebab6.png")
                                startActivity(intent)
                            }
                        }
                }
            }
        }
    }

    fun cekActivityComplete(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()
        if (getUserEmail != null) {
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab4").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab5").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("GamePuzzleBab6").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
        }
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                startActivity(Intent(this, HomeActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed(){
        super.onBackPressed()
    }

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed(){
            Log.d("onBack", "Exit to Home")
        }
    }
}