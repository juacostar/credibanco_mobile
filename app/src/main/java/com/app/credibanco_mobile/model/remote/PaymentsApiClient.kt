package com.app.credibanco_mobile.model.remote

import com.app.credibanco_mobile.model.dto.AnnulmentRequest
import com.app.credibanco_mobile.model.dto.AnnulmentResponse
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import com.app.credibanco_mobile.model.dto.AuthorizationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface PaymentsApiClient {

    @POST("/api/payments/authorization")
    suspend fun authorizeTransaction(
        @Header("Authorization") token: String,
        @Body authorizationRequest: AuthorizationRequest
    ):Response<AuthorizationResponse>

    @POST("/api/payments/annulation")
    suspend fun annulTransaction(
        @Header("Authorization") token: String,
        @Body annulmentRequest: AnnulmentRequest
    ):Response<AnnulmentResponse>



}