package com.example.AplBhsDaerah.home.sub.bab5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.data.BarisIstilah
import com.example.AplBhsDaerah.databinding.ActivityBerbicara5Binding
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.example.AplBhsDaerah.home.sub.bab4.Menyimak4Activity
import com.geco.zhyskaapp.data.BarisSoal
import com.geco.zhyskaapp.data.Soal
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Berbicara5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityBerbicara5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerbicara5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {

            btnCekJawabanIstilahBerbicara5.setOnClickListener {
                cekJawabanIstilah()
            }

            btnCekJawabanDilarangBerbicara5.setOnClickListener {
                cekJawabanDihindari()
            }

            btnCekJawabanDilakukanBerbicara5.setOnClickListener {
                cekJawabanDilakukan()
            }

            btnBerbicara5Selesai.setOnClickListener {
                val jawaban1 = inputJawabanBerbicara5no1.text.toString()
                val jawaban2 = inputJawabanBerbicara5no2.text.toString()
                val jawaban3 = inputJawabanBerbicara5no3.text.toString()

                cekSkorIstilah()
                cekSkorDihindari()
                cekSkorDilakukan()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor

                val activityStatus = "done"

                val skorBerbicara5 = pref.getInt("berbicara5", 0)

                if(skorBerbicara5 == 0){
                    editor.putInt("berbicara5", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Berbicara5Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }

                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("berbicara1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("berbicara2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("berbicara3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("berbicara5").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("berbicara5").setValue(activityStatus)

                }
                skor = 0
                val intent = Intent(this@Berbicara5Activity, SubBab5Activity::class.java)
                startActivity(intent)
            }

            dragLinearIstilah.apply {
                setContainerScrollView(scrollIstilah)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElementsIstilah(startPosition, endPosition)
                }
            }
            addIstilah.forEach {
                addRowIstilah(it)
            }

            dragLinearDilarang.apply {
                setContainerScrollView(scrollDilarang)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElementsDihindari(startPosition, endPosition)
                }
            }
            addDihindari.forEach {
                addRowDihindari(it)
            }

            dragLinearDilakukan.apply {
                setContainerScrollView(scrollDilakukan)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElementsDilakukan(startPosition, endPosition)
                }
            }
            addDilakukan.forEach {
                addRowDilakukan(it)
            }
        }
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun addRowIstilah(soal: Soal) {
        BarisIstilah(this).run row@{
            initRow(soal)
            binding.dragLinearIstilah.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }
    private fun swapElementsIstilah(startPosition: Int, endPosition: Int) {
        addIstilah.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }

    private fun addRowDihindari(soal: Soal) {
        BarisSoal(this).run row@{
            initRow(soal)
            binding.dragLinearDilarang.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }
    private fun swapElementsDihindari(startPosition: Int, endPosition: Int) {
        addDihindari.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }

    private fun addRowDilakukan(soal: Soal) {
        BarisSoal(this).run row@{
            initRow(soal)
            binding.dragLinearDilakukan.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }
    private fun swapElementsDilakukan(startPosition: Int, endPosition: Int) {
        addDilakukan.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }

    private fun cekSkorIstilah(){
        if(addIstilah[0].toString() == "Soal(kodeSoal=Ber5Istilah1, teksSoal=: sejenis permainan yang menggunakan batu atau bola kecil)"){
            skor += 10
        }
        if(addIstilah[1].toString() == "Soal(kodeSoal=Ber5Istilah2, teksSoal=: bermain congklan)"){
            skor += 10
        }
        if(addIstilah[2].toString() == "Soal(kodeSoal=Ber5Istilah3, teksSoal=: bermain karet)"){
            skor += 10
        }
        if(addIstilah[3].toString() == "Soal(kodeSoal=Ber5Istilah4, teksSoal=: bermain lompat karet)"){
            skor += 10
        }
        if(addIstilah[4].toString() == "Soal(kodeSoal=Ber5Istilah5, teksSoal=: bermain jingkrat)"){
            skor += 10
        }
        if(addIstilah[5].toString() == "Soal(kodeSoal=Ber5Istilah6, teksSoal=: bermain sepak bola)"){
            skor += 10
        }
        if(addIstilah[6].toString() == "Soal(kodeSoal=Ber5Istilah7, teksSoal=: bermain bola raga)"){
            skor += 10
        }
        if(addIstilah[7].toString() == "Soal(kodeSoal=Ber5Istilah8, teksSoal=: bermain dengan biji-bijian)"){
            skor += 10
        }
    }

    private fun cekSkorDihindari(){
        if(addDihindari[0].toString() == "Soal(kodeSoal=Ber5Dihindari1, teksSoal=curang)"){
            skor += 10
        }
        if(addDihindari[1].toString() == "Soal(kodeSoal=Ber5Dihindari2, teksSoal=berbohong)"){
            skor += 10
        }
        if(addDihindari[2].toString() == "Soal(kodeSoal=Ber5Dihindari3, teksSoal=memihak)"){
            skor += 10
        }
        if(addDihindari[3].toString() == "Soal(kodeSoal=Ber5Dihindari4, teksSoal=bertengkar)"){
            skor += 10
        }
        if(addDihindari[4].toString() == "Soal(kodeSoal=Ber5Dihindari5, teksSoal=saling menghujat)"){
            skor += 10
        }
        if(addDihindari[5].toString() == "Soal(kodeSoal=Ber5Dihindari6, teksSoal=saling bermusuhan)"){
            skor += 10
        }
        if(addDihindari[6].toString() == "Soal(kodeSoal=Ber5Dihindari7, teksSoal=saling mendendam)"){
            skor += 10
        }
        if(addDihindari[7].toString() == "Soal(kodeSoal=Ber5Dihindari8, teksSoal=berkelahi)"){
            skor += 10
        }
        if(addDihindari[8].toString() == "Soal(kodeSoal=Ber5Dihindari9, teksSoal=mencemooh)"){
            skor += 10
        }
        if(addDihindari[9].toString() == "Soal(kodeSoal=Ber5Dihindari10, teksSoal=saling mencela)"){
            skor += 10
        }
    }

    private fun cekSkorDilakukan(){
        if(addDilakukan[0].toString() == "Soal(kodeSoal=Ber5Dilakukan1, teksSoal=jujur, lurus)"){
            skor += 10
        }
        if(addDilakukan[1].toString() == "Soal(kodeSoal=Ber5Dilakukan2, teksSoal=adil)"){
            skor += 10
        }
        if(addDilakukan[2].toString() == "Soal(kodeSoal=Ber5Dilakukan3, teksSoal=kerja sama)"){
            skor += 10
        }
        if(addDilakukan[3].toString() == "Soal(kodeSoal=Ber5Dilakukan4, teksSoal=bersenang-senang)"){
            skor += 10
        }
        if(addDilakukan[4].toString() == "Soal(kodeSoal=Ber5Dilakukan5, teksSoal=saling menghargai)"){
            skor += 10
        }
        if(addDilakukan[5].toString() == "Soal(kodeSoal=Ber5Dilakukan6, teksSoal=saling mengakui)"){
            skor += 10
        }
        if(addDilakukan[6].toString() == "Soal(kodeSoal=Ber5Dilakukan7, teksSoal=berani)"){
            skor += 10
        }
        if(addDilakukan[7].toString() == "Soal(kodeSoal=Ber5Dilakukan8, teksSoal=bersungguh-sungguh)"){
            skor += 10
        }
    }

    private fun cekJawabanIstilah(){
        if(addIstilah[0].toString() == "Soal(kodeSoal=Ber5Istilah1, teksSoal=: sejenis permainan yang menggunakan batu atau bola kecil)"){
            binding.tvIstilah1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah1.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[1].toString() == "Soal(kodeSoal=Ber5Istilah2, teksSoal=: bermain congklan)"){
            binding.tvIstilah2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah2.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[2].toString() == "Soal(kodeSoal=Ber5Istilah3, teksSoal=: bermain karet)"){
            binding.tvIstilah3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah3.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[3].toString() == "Soal(kodeSoal=Ber5Istilah4, teksSoal=: bermain lompat karet)"){
            binding.tvIstilah4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah4.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[4].toString() == "Soal(kodeSoal=Ber5Istilah5, teksSoal=: bermain jingkrat)"){
            binding.tvIstilah5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah5.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[5].toString() == "Soal(kodeSoal=Ber5Istilah6, teksSoal=: bermain sepak bola)"){
            binding.tvIstilah6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah6.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[6].toString() == "Soal(kodeSoal=Ber5Istilah7, teksSoal=: bermain bola raga)"){
            binding.tvIstilah7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah7.setBackgroundColor(Color.WHITE)
        }
        if(addIstilah[7].toString() == "Soal(kodeSoal=Ber5Istilah8, teksSoal=: bermain dengan biji-bijian)"){
            binding.tvIstilah8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvIstilah8.setBackgroundColor(Color.WHITE)
        }
    }

    private fun cekJawabanDihindari(){
        if(addDihindari[0].toString() == "Soal(kodeSoal=Ber5Dihindari1, teksSoal=curang)"){
            binding.tvDilarang1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang1.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[1].toString() == "Soal(kodeSoal=Ber5Dihindari2, teksSoal=berbohong)"){
            binding.tvDilarang2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang2.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[2].toString() == "Soal(kodeSoal=Ber5Dihindari3, teksSoal=memihak)"){
            binding.tvDilarang3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang3.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[3].toString() == "Soal(kodeSoal=Ber5Dihindari4, teksSoal=bertengkar)"){
            binding.tvDilarang4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang4.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[4].toString() == "Soal(kodeSoal=Ber5Dihindari5, teksSoal=saling menghujat)"){
            binding.tvDilarang5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang5.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[5].toString() == "Soal(kodeSoal=Ber5Dihindari6, teksSoal=saling bermusuhan)"){
            binding.tvDilarang6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang6.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[6].toString() == "Soal(kodeSoal=Ber5Dihindari7, teksSoal=saling mendendam)"){
            binding.tvDilarang7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang7.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[7].toString() == "Soal(kodeSoal=Ber5Dihindari8, teksSoal=berkelahi)"){
            binding.tvDilarang8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang8.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[8].toString() == "Soal(kodeSoal=Ber5Dihindari9, teksSoal=mencemooh)"){
            binding.tvDilarang9.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang9.setBackgroundColor(Color.WHITE)
        }
        if(addDihindari[9].toString() == "Soal(kodeSoal=Ber5Dihindari10, teksSoal=saling mencela)"){
            binding.tvDilarang10.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilarang10.setBackgroundColor(Color.WHITE)
        }
    }

    private fun cekJawabanDilakukan(){
        if(addDilakukan[0].toString() == "Soal(kodeSoal=Ber5Dilakukan1, teksSoal=jujur, lurus)"){
            binding.tvDilakukan1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan1.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[1].toString() == "Soal(kodeSoal=Ber5Dilakukan2, teksSoal=adil)"){
            binding.tvDilakukan2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan2.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[2].toString() == "Soal(kodeSoal=Ber5Dilakukan3, teksSoal=kerja sama)"){
            binding.tvDilakukan3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan3.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[3].toString() == "Soal(kodeSoal=Ber5Dilakukan4, teksSoal=bersenang-senang)"){
            binding.tvDilakukan4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan4.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[4].toString() == "Soal(kodeSoal=Ber5Dilakukan5, teksSoal=saling menghargai)"){
            binding.tvDilakukan5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan5.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[5].toString() == "Soal(kodeSoal=Ber5Dilakukan6, teksSoal=saling mengakui)"){
            binding.tvDilakukan6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan6.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[6].toString() == "Soal(kodeSoal=Ber5Dilakukan7, teksSoal=berani)"){
            binding.tvDilakukan7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan7.setBackgroundColor(Color.WHITE)
        }
        if(addDilakukan[7].toString() == "Soal(kodeSoal=Ber5Dilakukan8, teksSoal=bersungguh-sungguh)"){
            binding.tvDilakukan8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tvDilakukan8.setBackgroundColor(Color.WHITE)
        }
    }

    companion object {
        var skor = 0
        private val addIstilah = mutableListOf(
            Soal("Ber5Istilah1",": sejenis permainan yang menggunakan batu atau bola kecil"),
            Soal("Ber5Istilah4",": bermain lompat karet"),
            Soal("Ber5Istilah3",": bermain karet"),
            Soal("Ber5Istilah5",": bermain jingkrat"),
            Soal("Ber5Istilah7",": bermain bola raga"),
            Soal("Ber5Istilah6",": bermain sepak bola"),
            Soal("Ber5Istilah2",": bermain congklan"),
            Soal("Ber5Istilah8",": bermain dengan biji-bijian")
        )

        private val addDihindari = mutableListOf(
            Soal("Ber5Dihindari1","curang"),
            Soal("Ber5Dihindari3","memihak"),
            Soal("Ber5Dihindari8","berkelahi"),
            Soal("Ber5Dihindari4","bertengkar"),
            Soal("Ber5Dihindari2","berbohong"),
            Soal("Ber5Dihindari6","saling bermusuhan"),
            Soal("Ber5Dihindari9","mencemooh"),
            Soal("Ber5Dihindari7","saling mendendam"),
            Soal("Ber5Dihindari5","saling menghujat"),
            Soal("Ber5Dihindari10","saling mencela")
        )

        private val addDilakukan = mutableListOf(
            Soal("Ber5Dilakukan1","jujur, lurus"),
            Soal("Ber5Dilakukan2","adil"),
            Soal("Ber5Dilakukan5","saling menghargai"),
            Soal("Ber5Dilakukan7","berani"),
            Soal("Ber5Dilakukan6","saling mengakui"),
            Soal("Ber5Dilakukan3","kerja sama"),
            Soal("Ber5Dilakukan4","bersenang-senang"),
            Soal("Ber5Dilakukan8","bersungguh-sungguh")
        )
    }


}