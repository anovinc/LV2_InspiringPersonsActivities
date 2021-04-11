package com.example.inspiringpersons

import android.media.Image
import java.io.Serializable

data class InspiringPerson(
    val name: String,
    val picture: String,
    val lifetime: String,
    val details: String,
    val quotes: List<String>
):Serializable