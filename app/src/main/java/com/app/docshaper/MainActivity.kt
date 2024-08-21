package com.app.docshaper

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.LifecycleStartEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.docshaper.core.SettingsConstants.FIRST_LAUNCH
import com.app.docshaper.data.settings.SettingsDataStore
import com.app.docshaper.presentation.DocShaperApp
import com.app.docshaper.presentation.settings_screen.SettingsViewModel
import com.app.docshaper.ui.theme.DocShaperTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val settingsViewModel: SettingsViewModel by viewModels()

    @Inject
    lateinit var settingsDataStore: SettingsDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(
                Color.WHITE,
                Color.WHITE
            )
        )
        val splashScreen = installSplashScreen()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
            //TODO Exit animation for the splash Screen
        }

        splashScreen.setKeepOnScreenCondition { settingsViewModel.setKeepOnScreenCondition }
        setContent {
            val firstLaunch = runBlocking { settingsDataStore.getBoolean(FIRST_LAUNCH) ?: true }
            val settingsState = settingsViewModel.state.collectAsStateWithLifecycle()
            DocShaperTheme(
                darkMode = settingsState.value.darkMode,
                amoledMode = settingsState.value.amoledTheme,
                dynamicTheming = settingsState.value.dynamicTheming
            ) {
                DocShaperApp(
                    firstLaunch = firstLaunch,
                    settingsViewModel = settingsViewModel,
                    finishActivity = {
                        finish()
                    }
                )
            }
        }
    }

}