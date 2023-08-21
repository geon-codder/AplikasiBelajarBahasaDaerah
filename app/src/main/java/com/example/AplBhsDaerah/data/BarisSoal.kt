package com.geco.zhyskaapp.data

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.AplBhsDaerah.R


class BarisSoal (context: Context?, attrs: AttributeSet? = null) :
    ConstraintLayout(context!!, attrs) {

    val kodeSoal: TextView
    val teksSoal: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.row_barissoal, this)
        kodeSoal = findViewById(R.id.kodeSoal)
        teksSoal = findViewById(R.id.teksSoal)
    }

    fun initRow(soal: Soal) {
        kodeSoal.text = soal.kodeSoal
        teksSoal.text = soal.teksSoal
    }
}