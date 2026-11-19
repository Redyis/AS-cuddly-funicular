package com.redyis.as_cuddly_funicular.presentation.ui

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import com.redyis.as_cuddly_funicular.presentation.viewmodel.AppDetailsState
import com.redyis.as_cuddly_funicular.presentation.viewmodel.AppDetailsViewModel

@Composable
fun AppDetailsScreen(
    onShowcaseAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    apps: List<AppItem> = emptyList(),
    viewModel: AppDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

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


        if (state is AppDetailsState.Content) {
            val contentState = state as AppDetailsState.Content
            InstallButton(
                installState = contentState.installState,
                onClick = { viewModel.onInstallClick() },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppDescription(
            description = "Легендарный рейд героев...",
            collapsed = false,
            modifier = Modifier.padding(horizontal = 16.dp),
            onReadMoreClick = {}
        )

        Spacer(modifier = Modifier.height(32.dp))

        ShowcaseBlock(
            apps = apps,
            onAppClick = { onShowcaseAppClick() }
        )
    }
}