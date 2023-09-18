package com.app.credibanco_mobile.model.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.98:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}