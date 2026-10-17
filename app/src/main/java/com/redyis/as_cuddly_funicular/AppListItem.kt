package com.redyis.as_cuddly_funicular

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme

@Composable

fun AppListItem(
    app: AppItem,
    modifier: Modifier = Modifier
)
{
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Image(
            painter = painterResource(id = app.iconRes),
            contentDescription = app.name,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = app.name, fontWeight = FontWeight.Bold)
            Text(text = app.description, color = Color.Gray)
            Text(text = app.category, color = Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListItemPreview() {
    // 👈 Обязательно обворачиваем в тему проекта!
    AScuddlyfunicularTheme {
        AppListItem(
            app = AppItem(
                iconRes = R.drawable.ic_launcher_foreground,
                name = "VK Музыка",
                description = "Слушайте треки без ограничений",
                category = "Музыка"
            )
        )
    }
}