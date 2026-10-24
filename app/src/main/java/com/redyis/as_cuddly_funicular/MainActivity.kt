package com.redyis.as_cuddly_funicular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AScuddlyfunicularTheme {

                val viewModel: AppViewModel = viewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()


                val navController = rememberNavController()
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember { SnackbarHostState() }


                LaunchedEffect(state.snackbarMessage) {
                    state.snackbarMessage?.let { message ->
                        viewModel.clearSnackbarMessage()

                        scope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }
                }


                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    topBar = {
                        Toolbar(
                            onLogoClick = { viewModel.onToolbarClick() }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "list",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("list") {
                            LazyColumn {
                                items(state.apps) { app ->
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