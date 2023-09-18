package com.app.credibanco_mobile.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.app.credibanco_mobile.model.data.dao.TransactionDao
import com.app.credibanco_mobile.model.data.entity.TransactionEntity
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import com.app.credibanco_mobile.model.dto.AuthorizationResponse
import com.app.credibanco_mobile.model.mapper.PaymentsMapper
import com.app.credibanco_mobile.model.remote.PaymentsApiDataSource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class PaymentsRepository @Inject constructor(
    private val paymentsApiDataSource: PaymentsApiDataSource,
    private val transactionDao: TransactionDao
): AppCompatActivity(){

    val mapper = PaymentsMapper()

//    suspend fun findAllTransactions(): List<TransactionEntity> {
//        return null
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun authorizeTransaction(authorizationRequest: AuthorizationRequest): TransactionEntity {
        val response = paymentsApiDataSource.authorizeTransaction(authorizationRequest).body()!!
        val entity = mapper.responseToEntitiy(response, authorizationRequest)
        transactionDao.insertTransaction(entity)
        return entity
    }

}