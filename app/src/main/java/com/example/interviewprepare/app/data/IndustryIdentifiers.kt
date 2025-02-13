package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class IndustryIdentifiers(
    @SerializedName("type") val type: String,
    @SerializedName("identifier") val identifier: String
)