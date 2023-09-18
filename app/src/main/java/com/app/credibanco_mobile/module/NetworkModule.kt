package com.app.credibanco_mobile.module

import com.app.credibanco_mobile.model.remote.PaymentsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.98:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePaymentsApiClient(retrofit: Retrofit): PaymentsApiClient{
        return retrofit.create(PaymentsApiClient::class.java)
    }
}