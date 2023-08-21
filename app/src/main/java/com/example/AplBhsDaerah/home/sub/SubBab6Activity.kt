package com.example.AplBhsDaerah.home.sub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import com.example.AplBhsDaerah.databinding.ActivitySubBab6Binding
import com.example.AplBhsDaerah.home.Kelas4Activity
import com.example.AplBhsDaerah.home.sub.bab6.Berbicara6Activity
import com.example.AplBhsDaerah.home.sub.bab6.Membaca6Activity
import com.example.AplBhsDaerah.home.sub.bab6.Menulis6Activity
import com.example.AplBhsDaerah.home.sub.bab6.Menyimak6Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class SubBab6Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBab6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBab6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "Sub Bab 6"
        display?.setDisplayHomeAsUpEnabled(true)
        cekSkor()
        cekActivityComplete()
        binding.apply {
            btnMenyimak6.setOnClickListener {
                val intent = Intent(this@SubBab6Activity, Menyimak6Activity::class.java)
                startActivity(intent)
            }
            btnBerbicara6.setOnClickListener {
                val intent = Intent(this@SubBab6Activity, Berbicara6Activity::class.java)
                startActivity(intent)
            }
            btnMembaca6.setOnClickListener {
                val intent = Intent(this@SubBab6Activity, Membaca6Activity::class.java)
                startActivity(intent)
            }
            btnMenulis6.setOnClickListener {
                val intent = Intent(this@SubBab6Activity, Menulis6Activity::class.java)
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

    fun cekActivityComplete(){

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()
        if (getUserEmail != null) {
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menyimak6").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("berbicara6").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("membaca6").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menulis6").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
        }
    }


    fun cekSkor(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()

        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("puzzlebab4").get().addOnSuccessListener {
            if (it.exists()){
                val skorpuzzle6 = it.value.toString().toInt()
                puzzlebab6 = skorpuzzle6
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("membaca6").get().addOnSuccessListener {
            if (it.exists()){
                val skorberbicara6 = it.value.toString().toInt()
                membaca6 = skorberbicara6
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis6").get().addOnSuccessListener {
            if (it.exists()){
                val skormenulis6 = it.value.toString().toInt()
                menulis6 = skormenulis6
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menyimak6").get().addOnSuccessListener {
            if (it.exists()){
                val skormenyimak6 = it.value.toString().toInt()
                menyimak6 = skormenyimak6
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara6").get().addOnSuccessListener {
            if (it.exists()){
                val skorberbicara6 = it.value.toString().toInt()
                berbicara6 = skorberbicara6
            }
        }
        val totalSkor = "Skor: ${puzzlebab6 + berbicara6 + menyimak6 + membaca6 + menulis6}"
        binding.tvSkorSubBab6.text = totalSkor
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("subBab6").setValue(totalSkor)
    }
    

    override fun onBackPressed(){
        super.onBackPressed()
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed(){
            Log.d("onBack", "Exit to Home")
        }
    }

    companion object{
        var puzzlebab6 = 0
        var berbicara6 = 0
        var menyimak6 = 0
        var membaca6 = 0
        var menulis6 = 0
    }

}