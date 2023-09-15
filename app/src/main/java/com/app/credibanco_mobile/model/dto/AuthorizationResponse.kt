package com.app.credibanco_mobile.model.dto

import com.google.gson.annotations.SerializedName

data class AuthorizationResponse (

    @SerializedName("receiptId")
    val receiptId: String,

    @SerializedName("rrn")
    val rrn: String,

    @SerializedName("statusCode")
    val statusCode: String,

    @SerializedName("statusDescription")
    val statusDescription: String

    )