package com.example.interviewprepare.app.service

import com.example.interviewprepare.app.repository.Repository
import com.example.interviewprepare.app.repository.RepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val repository: Repository
}

class DefaultAppContainer : AppContainer {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiUrl)
        .build()

    private val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val repository: Repository
        get() = RepositoryImpl(service)
}