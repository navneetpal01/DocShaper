package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.docshaper.ui.theme.cloud_mist
import com.app.docshaper.ui.theme.pure_snow
import com.app.docshaper.ui.theme.urbanist_bold


@Composable
fun OnBoardingBottom(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
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
            .padding(horizontal = 10.dp, vertical = 30.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ElevatedButton(
            onClick = {

            },
            modifier = Modifier
                .weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = cloud_mist),
            shape = CircleShape
        ) {
            Text(
                text = "Skip",
                modifier = Modifier
                    .padding(vertical = 10.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = urbanist_bold,
                ),
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
        ElevatedButton(
            onClick = {

            },
            modifier = Modifier
                .padding(start = 5.dp)
                .weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
            shape = CircleShape,
        ) {
            Text(
                text = "Next",
                modifier = Modifier
                    .padding(vertical = 10.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = urbanist_bold,
                ),
                color = pure_snow
            )
        }
    }
}