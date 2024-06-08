package com.example.inshortsapp.network

import com.example.inshortsapp.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiProvider {
    fun provideApi() = Retrofit.Builder().baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}