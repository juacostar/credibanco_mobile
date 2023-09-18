package com.app.credibanco_mobile.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.app.credibanco_mobile.model.PaymentsRepository
import com.app.credibanco_mobile.model.data.entity.TransactionEntity
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import com.app.credibanco_mobile.model.dto.AuthorizationResponse
import javax.inject.Inject

class AuthorizeTransactionUseCase @Inject constructor(
    private val repository: PaymentsRepository
){

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(request: AuthorizationRequest):TransactionEntity = repository.authorizeTransaction(request)

}