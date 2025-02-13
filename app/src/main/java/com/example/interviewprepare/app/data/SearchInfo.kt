package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet") val textSnippet: String
)