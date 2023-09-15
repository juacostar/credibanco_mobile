package com.app.credibanco_mobile.model.dto

import com.google.gson.annotations.SerializedName

data class AuthorizationRequest(

    @SerializedName("id")
    val id: Int,

    @SerializedName("commerceCode")
    val commerceCode: String,

    @SerializedName("terminalCode")
    val terminalCode: String,

    @SerializedName("amount")
    val amount: String,

    @SerializedName("card")
    val card: String

)