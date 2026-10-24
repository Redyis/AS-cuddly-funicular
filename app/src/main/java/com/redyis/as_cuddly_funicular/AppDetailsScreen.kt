package com.redyis.as_cuddly_funicular

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppDescription(
            description = "Легендарный рейд героев...",
            collapsed = false,
            modifier = modifier.padding(horizontal = 16.dp),
            onReadMoreClick = {}
        )

        Spacer(modifier = Modifier.height(32.dp))

        ShowcaseBlock(
            apps = sampleApps,
            onAppClick = {onShowcaseAppClick()}
        )
    }
}