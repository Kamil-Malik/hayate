package com.lelestacia.hayate.feature.anime.initialization.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.lelestacia.hayate.common.theme.spacing

@Composable
internal fun InitializationScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = spacing.small,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
        Text(text = "Setting up few stuff for you")
    }
}

@Preview
@Composable
internal fun PreviewInitializationScreen() {
    AppTheme(
        dynamicColor = false
    ) {
        InitializationScreen()
    }
}