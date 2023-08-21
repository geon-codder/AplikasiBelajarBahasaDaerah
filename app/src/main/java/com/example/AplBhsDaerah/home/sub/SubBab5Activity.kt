package com.example.AplBhsDaerah.home.sub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.AplBhsDaerah.databinding.ActivitySubBab5Binding
import com.example.AplBhsDaerah.home.Kelas4Activity
import com.example.AplBhsDaerah.home.sub.bab5.Berbicara5Activity
import com.example.AplBhsDaerah.home.sub.bab5.Membaca5Activity
import com.example.AplBhsDaerah.home.sub.bab5.Menulis5Activity
import com.example.AplBhsDaerah.home.sub.bab5.Menyimak5Activity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class SubBab5Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBab5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBab5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "Sub Bab 5"
        display?.setDisplayHomeAsUpEnabled(true)

        cekActivityComplete()
        cekSkor()

        binding.apply {
            btnMenyimak5.setOnClickListener {
                val intent = Intent(this@SubBab5Activity, Menyimak5Activity::class.java)
                startActivity(intent)
            }
            btnBerbicara5.setOnClickListener {
                val intent = Intent(this@SubBab5Activity, Berbicara5Activity::class.java)
                startActivity(intent)
            }
            btnMembaca5.setOnClickListener {
                val intent = Intent(this@SubBab5Activity, Membaca5Activity::class.java)
                startActivity(intent)
            }
            btnMenulis5.setOnClickListener {
                val intent = Intent(this@SubBab5Activity, Menulis5Activity::class.java)
                startActivity(intent)
            }
        }
    }

    fun cekSkor(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()

        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("puzzlebab4").get().addOnSuccessListener {
            if (it.exists()){
                val skorpuzzle5 = it.value.toString().toInt()
                puzzlebab5 = skorpuzzle5
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("membaca5").get().addOnSuccessListener {
            if (it.exists()){
                val skorberbicara5 = it.value.toString().toInt()
                membaca5 = skorberbicara5
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis5").get().addOnSuccessListener {
            if (it.exists()){
                val skormenulis5 = it.value.toString().toInt()
                menulis5 = skormenulis5
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menyimak5").get().addOnSuccessListener {
            if (it.exists()){
                val skormenyimak5 = it.value.toString().toInt()
                menyimak5 = skormenyimak5
            }
        }
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara5").get().addOnSuccessListener {
            if (it.exists()){
                val skorberbicara5 = it.value.toString().toInt()
                berbicara5 = skorberbicara5
            }
        }
        val totalSkor = "Skor: ${puzzlebab5 + berbicara5 + menyimak5 + membaca5 + menulis5}"
        binding.tvSkorSubBab5.text = totalSkor
        myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("subBab5").setValue(totalSkor)
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

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    fun cekActivityComplete(){

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()
        if (getUserEmail != null) {
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menyimak5").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("berbicara5").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("membaca5").get().addOnSuccessListener {
                if (it.exists()){
                    val donechecker = it.value.toString()
                    if(donechecker == "done"){
                        onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
                    }
                }
            }
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menulis5").get().addOnSuccessListener {
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

    companion object{
        var puzzlebab5 = 0
        var berbicara5 = 0
        var menyimak5 = 0
        var membaca5 = 0
        var menulis5 = 0
    }

}