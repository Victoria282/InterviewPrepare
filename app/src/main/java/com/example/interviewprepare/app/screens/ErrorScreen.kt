package com.example.interviewprepare.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interviewprepare.R

@Composable
@Preview
fun PreviewErrorScreen() {
    ErrorScreen(retryAction = {}, Modifier)
}

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Image(
        contentDescription = "",
        modifier = Modifier
            .size(64.dp),
        painter = painterResource(R.drawable.error)
    )
    Text(
        text = stringResource(R.string.error_description),
        textAlign = TextAlign.Center
    )
    Spacer(Modifier.weight(0.1f))
    Button(
        onClick = retryAction
    ) {
        Text(text = stringResource(R.string.retry))
    }
}