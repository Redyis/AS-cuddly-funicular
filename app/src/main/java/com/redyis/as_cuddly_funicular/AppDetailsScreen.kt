package com.redyis.as_cuddly_funicular

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppDetailsScreen(
    onShowcaseAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Карточка приложения",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        AppDetailsHeader()
        InstallButton(
            onClick = {}
        )
        AppDescription(
            description = "Описание",
            collapsed = false,
            onReadMoreClick = {}
        )
        Text(
            text = "Подробное описание выбранного приложения из практической части.",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        ShowcaseBlock(
            apps = sampleApps,
            onAppClick = {onShowcaseAppClick()}
        )
    }
}