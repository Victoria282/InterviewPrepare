package com.example.interviewprepare.app.data

import com.google.gson.annotations.SerializedName

data class PanelizationSummary(
    @SerializedName("containsEpubBubbles") val containsEpubBubbles: Boolean,
    @SerializedName("containsImageBubbles") val containsImageBubbles: Boolean
)