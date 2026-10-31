package com.redyis.as_cuddly_funicular.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class AppScreenState(
    val apps: List<AppItem> = sampleApps,
    val snackbarMessage: String? = null
)

class MainViewModel : ViewModel(
    private val repository: AppRepository = AppRepositoryImpl()
) {
    private val _state = MutableStateFlow(AppScreenState())
    val state: StateFlow<AppScreenState> = _state.asStateFlow()

    fun onToolbarClick() {
        _state.update { it.copy(snackbarMessage = "Привет из Toolbar!") }
    }

    fun clearSnackbarMessage() {
        _state.update { it.copy(snackbarMessage = null) }
    }
}