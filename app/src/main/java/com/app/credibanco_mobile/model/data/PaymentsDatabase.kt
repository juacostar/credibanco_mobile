package com.app.credibanco_mobile.model.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.credibanco_mobile.model.data.dao.TransactionDao
import com.app.credibanco_mobile.model.data.entity.TransactionEntity

@Database(entities = [TransactionEntity::class],
version = 1)
abstract class PaymentsDatabase: RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
}