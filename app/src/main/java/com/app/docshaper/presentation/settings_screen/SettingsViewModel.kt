package com.app.docshaper.presentation.settings_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.docshaper.core.SettingsConstants
import com.app.docshaper.data.settings.SettingsDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
    var setKeepOnScreenCondition: Boolean = true

    init {
        viewModelScope.launch {
            val firstLaunch =
                async { settingsDataStore.getBoolean(SettingsConstants.FIRST_LAUNCH) ?: true }
            val darkMode = async { settingsDataStore.getBoolean(SettingsConstants.DARK_MODE_TYPE) }
            val amoledTheme =
                async { settingsDataStore.getBoolean(SettingsConstants.AMOLED_THEME_TYPE) ?: false }
            val dynamicTheming = async {
                settingsDataStore.getBoolean(SettingsConstants.DYNAMIC_THEME_TYPE) ?: false
            }
            _state.update {
                it.copy(
                    firstLaunch = firstLaunch.await(),
                    darkMode = darkMode.await(),
                    amoledTheme = amoledTheme.await(),
                    dynamicTheming = dynamicTheming.await()
                )
            }
            setKeepOnScreenCondition = false
        }
    }

    fun onEvent(event: SettingsEvent) {
        when (event) {
            SettingsEvent.SetFirstLaunch -> {
                viewModelScope.launch(Dispatchers.IO) {
                    settingsDataStore.putBoolean(SettingsConstants.FIRST_LAUNCH, false)
                    _state.update {
                        it.copy(firstLaunch = false)
                    }
                }
            }

            is SettingsEvent.SetDarkMode -> {
                viewModelScope.launch(Dispatchers.IO) {
                    when (event.darkMode) {
                        true -> {
                            settingsDataStore.putBoolean(SettingsConstants.DARK_MODE_TYPE, true)
                        }

                        false -> {
                            settingsDataStore.putBoolean(SettingsConstants.DARK_MODE_TYPE, false)
                        }

                        null -> {
                            settingsDataStore.deleteBoolean(SettingsConstants.DARK_MODE_TYPE)
                        }
                    }
                    _state.update {
                        it.copy(
                            darkMode = event.darkMode
                        )
                    }
                }
            }

            is SettingsEvent.SetAmoledTheme -> {
                viewModelScope.launch(Dispatchers.IO) {
                    settingsDataStore.putBoolean(SettingsConstants.AMOLED_THEME_TYPE, event.amoledTheme)
                    if (event.amoledTheme){

                    }
                }
            }

            is SettingsEvent.SetDynamicTheming -> TODO()
        }
    }


}