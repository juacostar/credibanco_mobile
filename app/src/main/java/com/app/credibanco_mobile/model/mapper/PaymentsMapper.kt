package com.app.credibanco_mobile.model.mapper

import com.app.credibanco_mobile.model.data.entity.TransactionEntity
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import com.app.credibanco_mobile.model.dto.AuthorizationResponse
import kotlin.random.Random

class PaymentsMapper {

    fun responseToEntitiy(response: AuthorizationResponse, request: AuthorizationRequest): TransactionEntity {
        return TransactionEntity(
            amount = request.amount,
            receiptId = response.receiptId,
            card = request.card,
            canceled = false,
            id = Random.nextInt(100)
        )
    }
}