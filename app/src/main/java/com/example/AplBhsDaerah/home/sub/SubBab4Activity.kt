package com.example.AplBhsDaerah.home.sub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.AplBhsDaerah.MainActivity
import com.example.AplBhsDaerah.databinding.ActivitySubBab4Binding
import com.example.AplBhsDaerah.game.GameActivity
import com.example.AplBhsDaerah.home.Kelas4Activity
import com.example.AplBhsDaerah.home.sub.bab4.Berbicara4Activity
import com.example.AplBhsDaerah.home.sub.bab4.Membaca4Activity
import com.example.AplBhsDaerah.home.sub.bab4.Menulis4Activity
import com.example.AplBhsDaerah.home.sub.bab4.Menyimak4Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class SubBab4Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBab4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBab4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "Sub Bab 4"
        display?.setDisplayHomeAsUpEnabled(true)
        cekActivityComplete()
        cekSkor()

        binding.apply {

            btnMenyimak4.setOnClickListener {
                val intent = Intent(this@SubBab4Activity, Menyimak4Activity::class.java)
                startActivity(intent)
            }
            btnBerbicara4.setOnClickListener {
                val intent = Intent(this@SubBab4Activity, Berbicara4Activity::class.java)
                startActivity(intent)
            }
            btnMembaca4.setOnClickListener {
                val intent = Intent(this@SubBab4Activity, Membaca4Activity::class.java)
                startActivity(intent)
            }
            btnMenulis4.setOnClickListener {
                val intent = Intent(this@SubBab4Activity, Menulis4Activity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                startActivity(Intent(this, Kelas4Activity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun cekSkor(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()

        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("puzzlebab4").get().addOnSuccessListener {
            if (it.exists()){
                val skorpuzzle4 = it.value.toString().toInt()
                puzzlebab4 = skorpuzzle4
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("membaca4").get().addOnSuccessListener {
            if (it.exists()){
                val skorberbicara4 = it.value.toString().toInt()
                membaca4 = skorberbicara4
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis4").get().addOnSuccessListener {
            if (it.exists()){
                val skormenulis4 = it.value.toString().toInt()
                menulis4 = skormenulis4
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menyimak4").get().addOnSuccessListener {
            if (it.exists()){
                val skormenyimak4 = it.value.toString().toInt()
                menyimak4 = skormenyimak4
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara4").get().addOnSuccessListener {
            if (it.exists()){
                val skorberbicara4 = it.value.toString().toInt()
                berbicara4 = skorberbicara4
            }
        }
        val totalSkor = "Skor: ${puzzlebab4 + berbicara4 + menyimak4 + membaca4 + menulis4}"
        binding.tvSkorSubBab4.text = totalSkor
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("subBab4").setValue(totalSkor)
    }

    fun cekActivityComplete(){

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()
        if (getUserEmail != null) {
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menyimak4").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("berbicara4").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){

                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("membaca4").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menulis4").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
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

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    companion object{
        var puzzlebab4 = 0
        var berbicara4 = 0
        var menyimak4 = 0
        var membaca4 = 0
        var menulis4 = 0
    }

}