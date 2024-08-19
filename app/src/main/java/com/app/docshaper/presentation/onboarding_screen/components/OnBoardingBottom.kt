package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.docshaper.ui.theme.urbanist_bold
import com.app.docshaper.ui.theme.urbanist_medium


@Composable
fun OnBoardingBottom() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        OnBoardingBottomButton()
        Spacer(modifier = Modifier.height(25.dp))
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
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer),
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
        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(10.dp)
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
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}