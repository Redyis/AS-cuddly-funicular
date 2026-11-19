package com.redyis.as_cuddly_funicular.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redyis.as_cuddly_funicular.domain.model.AppItem

@Composable
fun AppList(
    apps: List<AppItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(apps) { app ->
            AppListItem(app = app)
        }
    }
}