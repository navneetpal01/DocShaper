package com.app.docshaper.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.docshaper.presentation.navigation.Home
import com.app.docshaper.presentation.navigation.NavGraph
import com.app.docshaper.presentation.navigation.OnBoarding
import com.app.docshaper.presentation.settings_screen.SettingsViewModel


@Composable
fun DocShaperApp(
    firstLaunch: Boolean,
    settingsViewModel: SettingsViewModel,
    finishActivity: () -> Unit
) {
    val navController = rememberNavController()
    NavGraph(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        navController = navController,
        startDestination = if (firstLaunch) OnBoarding else Home,
        finishActivity = finishActivity,
        settingsViewModel = settingsViewModel,
    )

}
