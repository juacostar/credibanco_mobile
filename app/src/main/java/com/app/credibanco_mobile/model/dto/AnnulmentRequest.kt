package com.app.credibanco_mobile.model.dto

import com.google.gson.annotations.SerializedName

data class AnnulmentRequest(

    @SerializedName("receiptId")
    val receiptId: String,

    @SerializedName("rrn")
    val rrn: String
)
