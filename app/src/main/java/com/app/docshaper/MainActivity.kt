package com.app.docshaper

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.app.docshaper.core.SettingsConstants.FIRST_LAUNCH
import com.app.docshaper.data.settings.SettingsDataStore
import com.app.docshaper.presentation.navigation.Home
import com.app.docshaper.presentation.navigation.NavGraph
import com.app.docshaper.presentation.navigation.OnBoarding
import com.app.docshaper.presentation.onboarding_screen.OnBoardingScreen
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
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        setContent {
            val firstLaunch = runBlocking { settingsDataStore.getBoolean(FIRST_LAUNCH) }
            val settingsState = settingsViewModel.state.collectAsStateWithLifecycle()

            DocShaperTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    startDestination = OnBoarding
                )
            }
        }
    }

}