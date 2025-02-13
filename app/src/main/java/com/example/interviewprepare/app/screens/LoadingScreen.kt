package com.example.interviewprepare.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.interviewprepare.R

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) = Box(modifier.fillMaxSize()) {
    Image(
        contentDescription = stringResource(R.string.loading_description),
        painter = painterResource(R.drawable.loading),
        modifier = Modifier.size(64.dp)
            .align(Alignment.Center)
    )
}