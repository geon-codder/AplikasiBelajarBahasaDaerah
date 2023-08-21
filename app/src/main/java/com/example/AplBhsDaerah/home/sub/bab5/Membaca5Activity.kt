package com.example.AplBhsDaerah.home.sub.bab5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.data.BarisSoalBigger
import com.example.AplBhsDaerah.databinding.ActivityMembaca5Binding
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.example.AplBhsDaerah.home.sub.bab4.Membaca4Activity
import com.geco.zhyskaapp.data.BarisSoal
import com.geco.zhyskaapp.data.Soal
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Membaca5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMembaca5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMembaca5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {

            btnCekJawabanKosaMembaca5.setOnClickListener {
                cekJawabanKosakata()
            }

            btnMembaca5Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMembaca5no1.text.toString()
                val jawaban2a = inputJawabanMembaca5no2a.text.toString()
                val jawaban2b = inputJawabanMembaca5no2b.text.toString()
                val jawaban2c = inputJawabanMembaca5no2c.text.toString()
                val jawaban2d = inputJawabanMembaca5no2d.text.toString()
                val jawaban2e = inputJawabanMembaca5no2e.text.toString()
                val jawaban3latin1 = inputJawabanMembaca5no3latin1.text.toString()
                val jawaban3arti1 = inputJawabanMembaca5no3Arti1.text.toString()
                val jawaban3latin2 = inputJawabanMembaca5no3latin2.text.toString()
                val jawaban3arti2 = inputJawabanMembaca5no3Arti2.text.toString()
                val jawaban3latin3 = inputJawabanMembaca5no3latin3.text.toString()
                val jawaban3arti3 = inputJawabanMembaca5no3Arti3.text.toString()
                val jawaban3latin4 = inputJawabanMembaca5no3latin4.text.toString()
                val jawaban3arti4 = inputJawabanMembaca5no3Arti4.text.toString()
                val jawaban3latin5 = inputJawabanMembaca5no3latin5.text.toString()
                val jawaban3arti5 = inputJawabanMembaca5no3Arti5.text.toString()
                val jawaban3latin6 = inputJawabanMembaca5no3latin6.text.toString()
                val jawaban3arti6 = inputJawabanMembaca5no3Arti6.text.toString()
                val jawaban3latin7 = inputJawabanMembaca5no3latin7.text.toString()
                val jawaban3arti7 = inputJawabanMembaca5no3Arti7.text.toString()
                val jawaban3latin8 = inputJawabanMembaca5no3latin8.text.toString()
                val jawaban3arti8 = inputJawabanMembaca5no3Arti8.text.toString()
                val jawaban3latin9 = inputJawabanMembaca5no3latin9.text.toString()
                val jawaban3arti9 = inputJawabanMembaca5no3Arti9.text.toString()
                val jawaban3latin10 = inputJawabanMembaca5no3latin10.text.toString()
                val jawaban3arti10 = inputJawabanMembaca5no3Arti10.text.toString()
                val jawaban3latin11 = inputJawabanMembaca5no3latin11.text.toString()
                val jawaban3arti11 = inputJawabanMembaca5no3Arti11.text.toString()
                val jawaban3latin12 = inputJawabanMembaca5no3latin12.text.toString()
                val jawaban3arti12 = inputJawabanMembaca5no3Arti12.text.toString()

                cekSkorKosakata()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor
                val activityStatus = "done"

                val skorMembaca5 = pref.getInt("membaca5", 0)
                if(skorMembaca5 == 0){
                    editor.putInt("membaca5", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Membaca5Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca2a")
                        .setValue(jawaban2a)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca2b")
                        .setValue(jawaban2b)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca2c")
                        .setValue(jawaban2c)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca2d")
                        .setValue(jawaban2d)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca2e")
                        .setValue(jawaban2e)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin1")
                        .setValue(jawaban3latin1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti1")
                        .setValue(jawaban3arti1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin2")
                        .setValue(jawaban3latin2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti2")
                        .setValue(jawaban3arti2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin3")
                        .setValue(jawaban3latin3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti3")
                        .setValue(jawaban3arti3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin4")
                        .setValue(jawaban3latin4)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti4")
                        .setValue(jawaban3arti4)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin5")
                        .setValue(jawaban3latin5)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti5")
                        .setValue(jawaban3arti5)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin6")
                        .setValue(jawaban3latin6)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti6")
                        .setValue(jawaban3arti6)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin7")
                        .setValue(jawaban3latin7)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti7")
                        .setValue(jawaban3arti7)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin8")
                        .setValue(jawaban3latin8)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti8")
                        .setValue(jawaban3arti8)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin9")
                        .setValue(jawaban3latin9)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti9")
                        .setValue(jawaban3arti9)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin10")
                        .setValue(jawaban3latin10)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti10")
                        .setValue(jawaban3arti10)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin11")
                        .setValue(jawaban3latin11)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti11")
                        .setValue(jawaban3arti11)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3latin12")
                        .setValue(jawaban3latin12)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("membaca3arti12")
                        .setValue(jawaban3arti12)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("membaca5").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("membaca5").setValue(activityStatus)

                }

                val intent = Intent(this@Membaca5Activity, SubBab5Activity::class.java)
                startActivity(intent)
            }

            dragLinearKosamembaca5.apply {
                setContainerScrollView(scrollKosamembaca5)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElements(startPosition, endPosition)
                }
            }
            addKosakata.forEach {
                addRow(it)
            }
        }
    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun addRow(soal: Soal) {
        BarisSoalBigger(this).run row@{
            initRow(soal)
            binding.dragLinearKosamembaca5.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }
    private fun swapElements(startPosition: Int, endPosition: Int) {
        addKosakata.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }

    private fun cekSkorKosakata(){
        if(addKosakata[0].toString() == "Soal(kodeSoal=kosamembaca5_1, teksSoal=terang bulan)"){
            skor += 10
        }
        if(addKosakata[1].toString() == "Soal(kodeSoal=kosamembaca5_2, teksSoal=bulan)"){
            skor += 10
        }
        if(addKosakata[2].toString() == "Soal(kodeSoal=kosamembaca5_3, teksSoal=berkumpul)"){
            skor += 10
        }
        if(addKosakata[3].toString() == "Soal(kodeSoal=kosamembaca5_4, teksSoal=mengumpulkan)"){
            skor += 10
        }
        if(addKosakata[4].toString() == "Soal(kodeSoal=kosamembaca5_5, teksSoal=main-mainan)"){
            skor += 10
        }
        if(addKosakata[5].toString() == "Soal(kodeSoal=kosamembaca5_6, teksSoal=bermain-main)"){
            skor += 10
        }
        if(addKosakata[6].toString() == "Soal(kodeSoal=kosamembaca5_7, teksSoal=permainan)"){
            skor += 10
        }
        if(addKosakata[7].toString() == "Soal(kodeSoal=kosamembaca5_8, teksSoal=sembunyi)"){
            skor += 10
        }
        if(addKosakata[8].toString() == "Soal(kodeSoal=kosamembaca5_9, teksSoal=bersembunyi)"){
            skor += 10
        }
        if(addKosakata[9].toString() == "Soal(kodeSoal=kosamembaca5_10, teksSoal=menyembunyikan)"){
            skor += 10
        }
        if(addKosakata[10].toString() == "Soal(kodeSoal=kosamembaca5_11, teksSoal=disembunyikan)"){
            skor += 10
        }
        if(addKosakata[11].toString() == "Soal(kodeSoal=kosamembaca5_12, teksSoal=bermain sembunyi-sembunyi)"){
            skor += 10
        }
        if(addKosakata[12].toString() == "Soal(kodeSoal=kosamembaca5_13, teksSoal=kopiah)"){
            skor += 10
        }
        if(addKosakata[13].toString() == "Soal(kodeSoal=kosamembaca5_14, teksSoal=kurungan ayam)"){
            skor += 10
        }
        if(addKosakata[14].toString() == "Soal(kodeSoal=kosamembaca5_15, teksSoal=gasin)"){
            skor += 10
        }
        if(addKosakata[15].toString() == "Soal(kodeSoal=kosamembaca5_16, teksSoal=bermain gasin)"){
            skor += 10
        }
    }

    private fun cekJawabanKosakata(){
        if(addKosakata[0].toString() == "Soal(kodeSoal=kosamembaca5_1, teksSoal=terang bulan)"){
            binding.tva1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva1.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[1].toString() == "Soal(kodeSoal=kosamembaca5_2, teksSoal=bulan)"){
            binding.tva2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva2.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[2].toString() == "Soal(kodeSoal=kosamembaca5_3, teksSoal=berkumpul)"){
            binding.tva3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva3.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[3].toString() == "Soal(kodeSoal=kosamembaca5_4, teksSoal=mengumpulkan)"){
            binding.tva4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva4.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[4].toString() == "Soal(kodeSoal=kosamembaca5_5, teksSoal=main-mainan)"){
            binding.tva5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva5.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[5].toString() == "Soal(kodeSoal=kosamembaca5_6, teksSoal=bermain-main)"){
            binding.tva6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva6.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[6].toString() == "Soal(kodeSoal=kosamembaca5_7, teksSoal=permainan)"){
            binding.tva7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva7.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[7].toString() == "Soal(kodeSoal=kosamembaca5_8, teksSoal=sembunyi)"){
            binding.tva8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva8.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[8].toString() == "Soal(kodeSoal=kosamembaca5_9, teksSoal=bersembunyi)"){
            binding.tva9.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva9.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[9].toString() == "Soal(kodeSoal=kosamembaca5_10, teksSoal=menyembunyikan)"){
            binding.tva10.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva10.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[10].toString() == "Soal(kodeSoal=kosamembaca5_11, teksSoal=disembunyikan)"){
            binding.tva11.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva11.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[11].toString() == "Soal(kodeSoal=kosamembaca5_12, teksSoal=bermain sembunyi-sembunyi)"){
            binding.tva12.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva12.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[12].toString() == "Soal(kodeSoal=kosamembaca5_13, teksSoal=kopiah)"){
            binding.tva13.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva13.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[13].toString() == "Soal(kodeSoal=kosamembaca5_14, teksSoal=kurungan ayam)"){
            binding.tva14.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva14.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[14].toString() == "Soal(kodeSoal=kosamembaca5_15, teksSoal=gasin)"){
            binding.tva15.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva15.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[15].toString() == "Soal(kodeSoal=kosamembaca5_16, teksSoal=bermain gasin)"){
            binding.tva16.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva16.setBackgroundColor(Color.WHITE)
        }
    }

    companion object {
        var skor = 0

        private val addKosakata = mutableListOf(
            Soal("kosamembaca5_7","permainan"),
            Soal("kosamembaca5_1","terang bulan"),
            Soal("kosamembaca5_4","mengumpulkan"),
            Soal("kosamembaca5_2","bulan"),
            Soal("kosamembaca5_5","main-mainan"),
            Soal("kosamembaca5_9","bersembunyi"),
            Soal("kosamembaca5_14","kurungan ayam"),
            Soal("kosamembaca5_6","bermain-main"),
            Soal("kosamembaca5_8","sembunyi"),
            Soal("kosamembaca5_10","menyembunyikan"),
            Soal("kosamembaca5_3","berkumpul"),
            Soal("kosamembaca5_15","gasin"),
            Soal("kosamembaca5_11","disembunyikan"),
            Soal("kosamembaca5_13","kopiah"),
            Soal("kosamembaca5_12","bermain sembunyi-sembunyi"),
            Soal("kosamembaca5_16","bermain gasin")
        )
    }

}