package com.example.inshortsapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNewsFromServers(
        @Query("country") country:String ="in",
        @Query("sortBy") sortBy:String="publishedAt",
        @Query("category") category : String?,
        @Query("apiKey") apiKey:String="5a11f68c96f9435993cce56e213f51f6"
    ):Response<NewsModel>

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "Your API Key"
    ): Response<NewsModel>

}