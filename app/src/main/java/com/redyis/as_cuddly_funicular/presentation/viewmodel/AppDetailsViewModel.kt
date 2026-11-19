package com.redyis.as_cuddly_funicular.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface InstallState {
    data object NotInstalled : InstallState
    data class Installing(val progress: Int) : InstallState
    data object Installed : InstallState
}

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data class Content(
        val app: AppItem,
        val installState: InstallState = InstallState.NotInstalled
    ) : AppDetailsState
}

class AppDetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private var installJob: Job? = null

    fun setApp(app: AppItem) {
        _state.value = AppDetailsState.Content(app = app)
    }

    fun onInstallClick() {
        val current = _state.value
        if (current !is AppDetailsState.Content) return

        if (current.installState is InstallState.Installing) {
            installJob?.cancel()
            installJob = null
            _state.update { state ->
                if (state is AppDetailsState.Content) {
                    state.copy(installState = InstallState.NotInstalled)
                } else state
            }
        } else if (current.installState is InstallState.NotInstalled) {
            installJob = viewModelScope.launch {
                emulateInstall()
            }
        }
    }

    private suspend fun emulateInstall() {
        updateInstallState(InstallState.Installing(progress = 0))

        for (progress in 5..100 step 5) {
            delay(150)
            updateInstallState(InstallState.Installing(progress = progress))
        }

        updateInstallState(InstallState.Installed)
        installJob = null
    }

    private fun updateInstallState(newInstallState: InstallState) {
        _state.update { state ->
            if (state is AppDetailsState.Content) {
                state.copy(installState = newInstallState)
            } else state
        }
    }

}