package com.redyis.as_cuddly_funicular.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(
    val apps: List<AppItem> = emptyList(),
    val isLoading: Boolean = false,
    val snackbarMessage: String? = null
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState> = _state.asStateFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val appsList = repository.getApps()
                _state.update { it.copy(apps = appsList, isLoading = false) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        snackbarMessage = "Ошибка загрузки: ${e.message}"
                    )
                }
            }
        }
    }

    fun onToolbarClick() {
        _state.update { it.copy(snackbarMessage = "Toolbar clicked") }
    }

    fun clearSnackbarMessage() {
        _state.update { it.copy(snackbarMessage = null) }
    }
}