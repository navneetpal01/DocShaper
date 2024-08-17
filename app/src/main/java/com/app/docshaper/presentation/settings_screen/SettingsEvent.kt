package com.app.docshaper.presentation.settings_screen


sealed class SettingsEvent {
    data object SetFirstLaunch : SettingsEvent()
    data class SetDarkMode(val darkMode: Boolean?) : SettingsEvent()
    data class SetAmoledTheme(val amoledTheme: Boolean) : SettingsEvent()
    data class SetDynamicTheming(val dynamicTheming: Boolean) : SettingsEvent()
}

