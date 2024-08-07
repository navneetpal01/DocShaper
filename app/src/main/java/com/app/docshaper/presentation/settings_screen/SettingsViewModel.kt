package com.app.docshaper.presentation.settings_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.docshaper.core.SettingsConstants.FIRST_LAUNCH
import com.app.docshaper.data.settings.SettingsDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        SettingsState()
    )

    init {
        viewModelScope.launch {
            val firstLaunch = async { settingsDataStore.getBoolean(FIRST_LAUNCH) ?: true }
            _state.update {
                it.copy(
                    firstLaunch = firstLaunch.await()
                )
            }
        }
    }

    fun onEvent(event: SettingsEvent) {
        when (event) {
            SettingsEvent.SetFirstLaunch -> {
                viewModelScope.launch {
                    settingsDataStore.putBoolean(FIRST_LAUNCH, false)
                    _state.update {
                        it.copy(firstLaunch = false)
                    }
                }
            }
        }
    }


}