package com.app.docshaper.presentation.navigation

import androidx.activity.compose.BackHandler
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
    finishActivity: () -> Unit,
    settingsViewModel: SettingsViewModel
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable<OnBoarding> {
            BackHandler {
                finishActivity()
            }
            OnBoardingScreen()
        }

        navigation<Home>(
            startDestination = DocShaperRoute.Home
        ) {
            tabs()
        }


    }


}