package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun OnBoardingBottom() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OnBoardingBottomButton()
    }

}

@Composable
private fun OnBoardingBottomButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(15.dp),
        ) {
            Text(
                text = "Skip"
            )
        }
        Button(
            onClick = {

            },
            shape = RoundedCornerShape(15.dp),
        ) {
            Text(
                text = "Next"
            )
        }
    }
}