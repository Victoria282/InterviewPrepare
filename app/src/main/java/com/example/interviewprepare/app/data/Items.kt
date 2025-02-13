package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class Items (
    @SerializedName("kind") val kind : String,
    @SerializedName("id") val id : String,
    @SerializedName("etag") val etag : String,
    @SerializedName("selfLink") val selfLink : String,
    @SerializedName("volumeInfo") val volumeInfo : VolumeInfo,
    @SerializedName("saleInfo") val saleInfo : SaleInfo,
    @SerializedName("searchInfo") val searchInfo : SearchInfo
)