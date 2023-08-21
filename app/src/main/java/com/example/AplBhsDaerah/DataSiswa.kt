package com.example.AplBhsDaerah

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class DataSiswa(val user: String? = null,
                     val nama: String? = null,
                     val nis: String? = null,
                     val kelas: String? = null,
                     val alamat: String? = null,
                     val sekolah: String? = null) {
}