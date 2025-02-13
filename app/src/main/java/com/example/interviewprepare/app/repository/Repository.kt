package com.example.interviewprepare.app.repository

import com.example.interviewprepare.app.data.ui.Book
import com.example.interviewprepare.app.service.ApiService

interface Repository {
    suspend fun bookSearch(
        searchQuery: String,
        maxResults: Int
    ): List<Book>
}

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {
    override suspend fun bookSearch(searchQuery: String, maxResults: Int): List<Book> {
        val response = apiService.bookSearch(searchQuery, maxResults)
        return response.items.map { item ->
            Book(
                title = item.volumeInfo.title,
                previewLink = item.volumeInfo.previewLink,
                imageLink = item.volumeInfo.imageLinks.thumbnail
            )
        }
    }
}