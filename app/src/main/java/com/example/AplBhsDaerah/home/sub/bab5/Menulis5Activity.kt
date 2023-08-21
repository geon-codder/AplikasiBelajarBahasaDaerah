package com.example.AplBhsDaerah.home.sub.bab5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.data.BarisSoalBigger
import com.example.AplBhsDaerah.databinding.ActivityMenulis5Binding
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.example.AplBhsDaerah.home.sub.bab4.Menulis4Activity
import com.geco.zhyskaapp.data.BarisSoal
import com.geco.zhyskaapp.data.Soal
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Menulis5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMenulis5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenulis5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {

            btnCekJawabanKosaMenulis5.setOnClickListener {
                cekJawabanKosakata()
            }

            btnMenulis5Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMenulis5no1.text.toString()
                val jawaban2 = inputJawabanMenulis5no2.text.toString()
                val jawaban3 = inputJawabanMenulis5no3.text.toString()
                cekSkorKosakata()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor

                val activityStatus = "done"

                val skorMenulis5 = pref.getInt("menulis5", 0)

                if(skorMenulis5 == 0){
                    editor.putInt("menulis5", skorAkhir)
                    editor.apply()

                    Toast.makeText(this@Menulis5Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0


                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menulis1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menulis2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab5").child("menulis3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menulis5").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menulis5").setValue(activityStatus)
                }

                val intent = Intent(this@Menulis5Activity, SubBab5Activity::class.java)
                startActivity(intent)
            }
            dragLinearKosamenulis5.apply {
                setContainerScrollView(scrollKosamenulis5)
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
            binding.dragLinearKosamenulis5.run {
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
        if(addKosakata[0].toString() == "Soal(kodeSoal=kosamenulis5_1, teksSoal=ibu dan ayah)"){
            skor += 10
        }
        if(addKosakata[1].toString() == "Soal(kodeSoal=kosamenulis5_2, teksSoal=pengasuhannya)"){
            skor += 10
        }
        if(addKosakata[2].toString() == "Soal(kodeSoal=kosamenulis5_3, teksSoal=kasih sayangnya)"){
            skor += 10
        }
        if(addKosakata[3].toString() == "Soal(kodeSoal=kosamenulis5_4, teksSoal=mengasuh dengan penuh kasih sayang)"){
            skor += 10
        }
        if(addKosakata[4].toString() == "Soal(kodeSoal=kosamenulis5_5, teksSoal=saya tak sanggup membalasnya)"){
            skor += 10
        }
        if(addKosakata[5].toString() == "Soal(kodeSoal=kosamenulis5_6, teksSoal=anak yang bahagia)"){
            skor += 10
        }
        if(addKosakata[6].toString() == "Soal(kodeSoal=kosamenulis5_7, teksSoal=anak yang bahagia)"){
            skor += 10
        }
        if(addKosakata[7].toString() == "Soal(kodeSoal=kosamenulis5_8, teksSoal=membahagiakan)"){
            skor += 10
        }
        if(addKosakata[8].toString() == "Soal(kodeSoal=kosamenulis5_9, teksSoal=mencarikan rejeki)"){
            skor += 10
        }
        if(addKosakata[9].toString() == "Soal(kodeSoal=kosamenulis5_10, teksSoal=tenangkanlah hatimu)"){
            skor += 10
        }
        if(addKosakata[10].toString() == "Soal(kodeSoal=kosamenulis5_11, teksSoal=janganlah menangis)"){
            skor += 10
        }
        if(addKosakata[11].toString() == "Soal(kodeSoal=kosamenulis5_12, teksSoal=jangan gelisah)"){
            skor += 10
        }
    }

    private fun cekJawabanKosakata(){
        if(addKosakata[0].toString() == "Soal(kodeSoal=kosamenulis5_1, teksSoal=ibu dan ayah)"){
            binding.tva1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva1.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[1].toString() == "Soal(kodeSoal=kosamenulis5_2, teksSoal=pengasuhannya)"){
            binding.tva2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva2.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[2].toString() == "Soal(kodeSoal=kosamenulis5_3, teksSoal=kasih sayangnya)"){
            binding.tva3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva3.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[3].toString() == "Soal(kodeSoal=kosamenulis5_4, teksSoal=mengasuh dengan penuh kasih sayang)"){
            binding.tva4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva4.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[4].toString() == "Soal(kodeSoal=kosamenulis5_5, teksSoal=saya tak sanggup membalasnya)"){
            binding.tva5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva5.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[5].toString() == "Soal(kodeSoal=kosamenulis5_6, teksSoal=anak yang bahagia)"){
            binding.tva6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva6.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[6].toString() == "Soal(kodeSoal=kosamenulis5_7, teksSoal=anak yang bahagia)"){
            binding.tva7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva7.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[7].toString() == "Soal(kodeSoal=kosamenulis5_8, teksSoal=membahagiakan)"){
            binding.tva8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva8.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[8].toString() == "Soal(kodeSoal=kosamenulis5_9, teksSoal=mencarikan rejeki)"){
            binding.tva9.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva9.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[9].toString() == "Soal(kodeSoal=kosamenulis5_10, teksSoal=tenangkanlah hatimu)"){
            binding.tva10.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva10.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[10].toString() == "Soal(kodeSoal=kosamenulis5_11, teksSoal=janganlah menangis)"){
            binding.tva11.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva11.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[11].toString() == "Soal(kodeSoal=kosamenulis5_12, teksSoal=jangan gelisah)"){
            binding.tva12.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva12.setBackgroundColor(Color.WHITE)
        }
    }

    companion object {
        var skor = 0

        private val addKosakata = mutableListOf(
            Soal("kosamenulis5_1","ibu dan ayah"),
            Soal("kosamenulis5_5","saya tak sanggup membalasnya"),
            Soal("kosamenulis5_4","mengasuh dengan penuh kasih sayang"),
            Soal("kosamenulis5_3","kasih sayangnya"),
            Soal("kosamenulis5_6","anak yang bahagia"),
            Soal("kosamenulis5_9","mencarikan rejeki"),
            Soal("kosamenulis5_7","anak yang bahagia"),
            Soal("kosamenulis5_2","pengasuhannya"),
            Soal("kosamenulis5_8","membahagiakan"),
            Soal("kosamenulis5_11","janganlah menangis"),
            Soal("kosamenulis5_10","tenangkanlah hatimu"),
            Soal("kosamenulis5_12","jangan gelisah")
        )
    }
}