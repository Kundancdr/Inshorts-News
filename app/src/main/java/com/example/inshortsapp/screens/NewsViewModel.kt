package com.example.inshortsapp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inshortsapp.network.NewsModel
import com.example.inshortsapp.repo.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class NewsViewModel(): ViewModel() {
    var res = mutableStateOf<NewsModel?>(null)

    init {
        viewModelScope.launch {
            res.value= getNews(Repo())
        }
    }

  suspend  fun getNews(repo: Repo) : NewsModel? {
      return repo.newsProvider().body()
  }


    }
