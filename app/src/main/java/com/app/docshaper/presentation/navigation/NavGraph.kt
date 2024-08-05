package com.app.docshaper.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.app.docshaper.presentation.home_screen.HomeScreen
import com.app.docshaper.presentation.onboarding_screen.OnBoardingScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Any
) {

    NavHost(
        modifier = Modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = startDestination
    ) {

        composable<OnBoarding> {
            OnBoardingScreen()
        }

        navigation<Tabs>(
            startDestination = DocShaperTabs.Home
        ) {

        }


    }


}