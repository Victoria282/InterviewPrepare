package com.example.interviewprepare.app.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.interviewprepare.app.screens.components.BooksList
import com.example.interviewprepare.app.vm.BooksUiState

@Composable
@Preview
fun PreviewListScreen() {
    ListScreen(BooksUiState.Error, {}, Modifier)
}

@Composable
fun ListScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier
) = when (booksUiState) {
    BooksUiState.Loading -> LoadingScreen(modifier)
    BooksUiState.Error -> ErrorScreen(retryAction, modifier)
    is BooksUiState.Success -> BooksList(booksUiState.books)
}