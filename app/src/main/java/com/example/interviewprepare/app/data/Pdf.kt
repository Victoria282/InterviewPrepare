package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class Pdf(
    @SerializedName("isAvailable") val isAvailable: Boolean,
    @SerializedName("acsTokenLink") val acsTokenLink: String
)