package com.redyis.as_cuddly_funicular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AScuddlyfunicularTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {Toolbar()},
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "list",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable ("list") {
                            LazyColumn {
                                items(sampleApps) { app ->
                                    AppListItem(
                                        app = app,
                                        modifier = Modifier.clickable {
                                            navController.navigate("details")
                                        }
                                    )
                                }
                            }
                        }
                        composable("details") {
                            AppDetailsScreen(
                                onShowcaseAppClick = {
                                    navController.navigate("list")
                                }
                            )
                        }
                    }
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
