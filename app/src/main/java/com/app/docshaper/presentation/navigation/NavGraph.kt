package com.app.docshaper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.app.docshaper.presentation.onboarding_screen.OnBoardingScreen
import com.app.docshaper.presentation.settings_screen.SettingsViewModel

@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: Any,
    settingsViewModel: SettingsViewModel
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable<OnBoarding> {
            OnBoardingScreen()
        }

        navigation<Home>(
            startDestination = DocShaperRoute.Home
        ) {
            tabs()
        }


    }


}