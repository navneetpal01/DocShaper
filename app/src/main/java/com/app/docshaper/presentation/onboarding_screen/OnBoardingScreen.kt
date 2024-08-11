package com.app.docshaper.presentation.onboarding_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.docshaper.presentation.settings_screen.SettingsEvent
import com.app.docshaper.ui.theme.SYSTEM_OCEAN_BREEZE

@Composable
fun OnBoardingScreen(
    onCompleted: (SettingsEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SYSTEM_OCEAN_BREEZE),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                onCompleted(SettingsEvent.SetFirstLaunch)
            }
        ) {
            Text(text = "Complete")
        }
        Text(text = "OnBoarding Screen")
    }
}