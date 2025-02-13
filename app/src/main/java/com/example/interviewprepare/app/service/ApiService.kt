package com.example.interviewprepare.app.service

import com.example.interviewprepare.app.data.Books
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): Books
}

const val ApiUrl = "https://www.googleapis.com/books/v1/"