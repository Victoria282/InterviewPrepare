package com.example.interviewprepare.app.vm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.interviewprepare.app.Application
import com.example.interviewprepare.app.data.ui.Book
import com.example.interviewprepare.app.repository.Repository
import com.example.interviewprepare.app.service.AppContainer
import kotlinx.coroutines.launch

sealed interface BooksUiState {
    data class Success(val books: List<Book>) : BooksUiState
    data object Loading : BooksUiState
    data object Error : BooksUiState
}

class ActivityViewModel(
    private val appContainer: AppContainer
) : ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooks("book")
    }

    fun getBooks(search: String, max: Int = 30) = viewModelScope.launch {
        booksUiState = BooksUiState.Loading
        booksUiState = try {
            BooksUiState.Success(appContainer.repository.bookSearch(search, max))
        } catch (e: Exception) {
            Log.e("VIKA", "e= ${e}")
            BooksUiState.Error
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as Application)
                val repository = application.appContainer
                ActivityViewModel(repository)
            }
        }
    }
}