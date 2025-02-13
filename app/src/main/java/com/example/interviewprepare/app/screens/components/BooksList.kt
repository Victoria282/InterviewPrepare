package com.example.interviewprepare.app.screens.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.interviewprepare.app.data.ui.Book

@Composable
@Preview
fun PreviewBooksList() {
    BooksList(
        listOf(
            Book(
                "Война и мир",
                "", ""
            ),
            Book(
                "Преступление и наказание",
                "", ""
            ),
            Book(
                "Судьба человека",
                "", ""
            ),
            Book(
                "Вишневый сад",
                "", ""
            )
        )
    )
}

@Composable
fun BooksList(
    books: List<Book>
) = LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    modifier = Modifier
) {
    items(books) {
        BookCard(it, modifier = Modifier)
    }
}