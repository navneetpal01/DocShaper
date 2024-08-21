package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.app.docshaper.ui.theme.text_theme_dark_inversePrimary
import com.app.docshaper.ui.theme.urbanist_bold
import com.app.docshaper.ui.theme.urbanist_medium


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Welcome to DocShaper",
                fontSize = 30.sp,
                color = text_theme_dark_inversePrimary,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontFamily = urbanist_bold,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = "Get fast summary ask questions and understand your files in a seconds"
            )
        }
    }
}