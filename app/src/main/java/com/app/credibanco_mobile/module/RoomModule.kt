package com.app.credibanco_mobile.module

import android.content.Context
import androidx.room.Room
import com.app.credibanco_mobile.model.data.PaymentsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val TRANSACTIONS_DATABASE = "transaction_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        PaymentsDatabase::class.java, TRANSACTIONS_DATABASE
    ).build()


    @Singleton
    @Provides
    fun providePaymentsDao(db: PaymentsDatabase) = db.transactionDao()

}