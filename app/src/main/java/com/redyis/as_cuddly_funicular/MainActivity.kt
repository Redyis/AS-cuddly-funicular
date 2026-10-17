package com.redyis.as_cuddly_funicular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AScuddlyfunicularTheme {
                Scaffold(
                    topBar = {Toolbar()},
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppList(
                        apps = sampleApps,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AScuddlyfunicularTheme {
        Scaffold(
            topBar = { Toolbar() },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            AppList(
                apps = sampleApps,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
