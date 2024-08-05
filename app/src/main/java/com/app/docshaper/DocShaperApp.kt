package com.app.docshaper

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.docshaper.presentation.navigation.DocShaperTabs
import com.app.docshaper.presentation.navigation.NavGraph
import com.app.docshaper.presentation.navigation.OnBoarding
import com.app.docshaper.presentation.navigation.Home
import com.app.docshaper.presentation.settings_screen.SettingsViewModel
import com.app.docshaper.ui.theme.DocShaperTheme


@Composable
fun DocShaperApp(
    firstLaunch: Boolean,
    settingsViewModel: SettingsViewModel,
    finishActivity: () -> Unit
) {

    DocShaperTheme {
        val tabs = DocShaperTabs.values()
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {

            }
        ){ paddingValues ->
            NavGraph(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                navController = navController,
                startDestination = if (firstLaunch) OnBoarding else Home
            )
        }
    }


}