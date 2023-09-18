package com.app.credibanco_mobile.model.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "transaction")
data class TransactionEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "amount")
    val amount: String,

    @ColumnInfo(name = "card")
    val card: String,

    @ColumnInfo(name = "receipt_id")
    val receiptId: String,

    @ColumnInfo(name = "canceled")
    val canceled: Boolean
)