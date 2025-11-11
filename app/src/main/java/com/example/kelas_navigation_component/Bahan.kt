package com.example.kelas_navigation_component

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bahan(
    var nama : String,
    var kategori : String,
    val url : String
) : Parcelable
