package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("kind") val kind: String,
    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("items") val items: List<Items>
)