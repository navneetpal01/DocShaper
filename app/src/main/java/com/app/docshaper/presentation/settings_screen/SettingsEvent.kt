package com.app.docshaper.presentation.settings_screen


sealed class SettingsEvent{
    data object SetFirstLaunch : SettingsEvent()
}