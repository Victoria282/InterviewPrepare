package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class ReadingModes(
    @SerializedName("text") val text: Boolean,
    @SerializedName("image") val image: Boolean
)