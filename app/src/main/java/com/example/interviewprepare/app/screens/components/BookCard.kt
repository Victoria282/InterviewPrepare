package com.example.interviewprepare.app.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.interviewprepare.app.data.ui.Book

@Preview
@Composable
fun PreviewBookCard() {
    BookCard(
        Book(
            "Война и мир",
            "https://some.url.com",
            "https://some.url.png.com"
        ),
        Modifier
    )
}

@Composable
fun BookCard(
    book: Book,
    modifier: Modifier
) = Card(
    modifier = modifier
        .padding(4.dp)
        .fillMaxWidth()
        .requiredHeight(200.dp)
) {
    Column {
        book.title?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )
        }

        AsyncImage(
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            model = ImageRequest.Builder(
                context = LocalContext.current
            ).data(
                book.imageLink?.replace("http", "https")
            )
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}