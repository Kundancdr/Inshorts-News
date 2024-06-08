package com.example.inshortsapp.repo

import com.example.inshortsapp.network.ApiProvider
import com.example.inshortsapp.network.NewsModel
import retrofit2.Response

class Repo {
    suspend fun newsProvider(): Response<NewsModel>{
        return ApiProvider.provideApi().getNewsFromServers()


    }
}