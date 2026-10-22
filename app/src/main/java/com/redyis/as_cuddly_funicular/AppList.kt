package com.redyis.as_cuddly_funicular

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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