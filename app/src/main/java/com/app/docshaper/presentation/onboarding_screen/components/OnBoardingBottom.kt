package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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


@Composable
fun OnBoardingBottom(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onSkip: () -> Unit,
    onNext: () -> Unit
) {


    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OnBoardingIndicator(
            count = pagerState.pageCount,
            pagerState = pagerState,
        )
        OnBoardingBottomButton(
            onSkip = onSkip,
            onNext = onNext
        )
    }

}

@Composable
private fun OnBoardingBottomButton(
    onSkip: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 25.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ElevatedButton(
            onClick = onSkip,
            modifier = Modifier
                .weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#FAFAFA"))),
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
                color = Color(android.graphics.Color.parseColor("#2E75FF")),
            )
        }
        ElevatedButton(
            onClick = onNext,
            modifier = Modifier
                .padding(start = 5.dp)
                .weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#2E75FF"))),
            shape = CircleShape,
        ) { Text(
                text = "Next",
                modifier = Modifier
                    .padding(vertical = 10.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = urbanist_bold,
                ),
                color = Color.White
            )
        }
    }
}