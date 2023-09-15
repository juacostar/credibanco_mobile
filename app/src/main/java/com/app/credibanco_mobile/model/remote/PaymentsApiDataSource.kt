package com.app.credibanco_mobile.model.remote

import android.os.Build
import androidx.annotation.RequiresApi
import com.app.credibanco_mobile.model.core.RetrofitHelper
import com.app.credibanco_mobile.model.dto.AnnulmentRequest
import com.app.credibanco_mobile.model.dto.AnnulmentResponse
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import com.app.credibanco_mobile.model.dto.AuthorizationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.util.Base64
import javax.inject.Inject

class PaymentsApiDataSource @Inject constructor() {

    private val retrofit = RetrofitHelper.getRetrofit()

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun authorizeTransaction(request: AuthorizationRequest): Response<AuthorizationResponse>{
        return withContext(Dispatchers.IO){
            val token = base64("Basic " + request.commerceCode + request.terminalCode)
            val response = retrofit.create(PaymentsApiClient::class.java).authorizeTransaction(token, request)
            response
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun annulTransaction(request: AnnulmentRequest, commerceCode: String, terminalCode: String): Response<AnnulmentResponse>{
        return withContext(Dispatchers.IO){
            val token = base64("Basic " + commerceCode + terminalCode)
            val response = retrofit.create(PaymentsApiClient::class.java).annulTransaction(token, request)
            response
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun base64(value: String): String{

        val encodedBytes = Base64.getEncoder().encode(value.toByteArray())

        return String(encodedBytes)
    }


}