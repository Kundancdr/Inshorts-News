package com.example.inshortsapp.screens

 sealed class state<T>(val data :T? = null, val message :String? = null) {
     class Success <T> (data: T?) : state<T>(data=data)
     class Loading <T> (message: String?) : state<T>()
     class Error<T> (message: String?) :state<T>(message=message)
}