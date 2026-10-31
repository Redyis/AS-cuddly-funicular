package com.redyis.as_cuddly_funicular.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.redyis.as_cuddly_funicular.data.repository.AppRepositoryImpl
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// 1. Избавились от зависимости от sampleApps — дефолтное значение emptyList()
data class MainUiState(
    val apps: List<AppItem> = emptyList(),
    val snackbarMessage: String? = null
)

// 2. Корректный синтаксис первичного конструктора
class MainViewModel(
    private val repository: AppRepository = AppRepositoryImpl()
) : ViewModel() {

    // 3. Инициализируем состояние данными из репозитория
    private val _state = MutableStateFlow(
        MainUiState(apps = repository.getApps())
    )
    val state: StateFlow<MainUiState> = _state.asStateFlow()

    fun onToolbarClick() {
        _state.update { it.copy(snackbarMessage = "Toolbar clicked") }
    }

    fun clearSnackbarMessage() {
        _state.update { it.copy(snackbarMessage = null) }
    }
}