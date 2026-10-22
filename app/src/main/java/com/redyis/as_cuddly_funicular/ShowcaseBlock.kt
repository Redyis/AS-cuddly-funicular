package com.redyis.as_cuddly_funicular

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme

@Composable
fun ShowcaseBlock(
    apps: List<AppItem>,
    onAppClick: (AppItem) -> Unit,
    modifier: Modifier = Modifier
){
    val pages = remember(apps) { apps.chunked(3) }
    val pagesState = rememberPagerState(pageCount = { pages.size })

    Column(modifier = modifier) {
        Text(
            text = "Витрина",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )

        HorizontalPager(
            state = pagesState,
            modifier = Modifier.fillMaxWidth()
        ) { pageIndex ->
            Column (modifier = Modifier.fillMaxWidth()) {
                val pageApps = pages.getOrNull(pageIndex) ?: emptyList()
                pageApps.forEach { app ->
                    AppListItem(
                        app = app,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onAppClick(app)}
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun ShowcaseBlockPreview() {
//    AScuddlyfunicularTheme {
//        ShowcaseBlock(
//            apps = sampleApps,
//            onAppClick = {}
//        )
//    }
//}