package com.app.credibanco_mobile.model.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.credibanco_mobile.model.data.entity.TransactionEntity

@Dao
interface TransactionDao {

    @Query("select * from `transaction`")
    suspend fun findAllTransactions(): List<TransactionEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTransactions(transactions: List<TransactionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Delete()
    suspend fun deleteTransaction(transactionEntity: TransactionEntity)
}