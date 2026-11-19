package com.redyis.as_cuddly_funicular.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redyis.as_cuddly_funicular.presentation.viewmodel.MainViewModel
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AScuddlyfunicularTheme {


                val state by viewModel.state.collectAsStateWithLifecycle()


                val navController = rememberNavController()
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember { SnackbarHostState() }


                LaunchedEffect(state.snackbarMessage) {
                    state.snackbarMessage?.let { message ->
                        snackbarHostState.showSnackbar(message)
                        viewModel.clearSnackbarMessage()
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
                                apps = state.apps,
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