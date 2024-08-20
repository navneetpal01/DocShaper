package com.app.docshaper.presentation.onboarding_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.docshaper.presentation.onboarding_screen.components.OnBoardingBottom
import com.app.docshaper.presentation.settings_screen.SettingsEvent

@Composable
fun OnBoardingScreen(
    onCompleted: (SettingsEvent) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 0) {
        3
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            OnBoardingBottom(
                pagerState = pagerState,
                onSkip = {

                },
                onNext = {

                }
            )
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }
}