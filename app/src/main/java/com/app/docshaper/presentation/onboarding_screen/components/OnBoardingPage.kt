package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.docshaper.R
import com.app.docshaper.ui.theme.urbanist_bold
import com.app.docshaper.ui.theme.urbanist_regular


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.image),
            contentScale = ContentScale.Crop,
            contentDescription = "onboarding_image"
        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                text = "Welcome to DocShaper",
                fontSize = 30.sp,
                color = Color(android.graphics.Color.parseColor("#39434F")),
                fontWeight = FontWeight.Bold,
                fontFamily = urbanist_bold,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                text = "All in one pdf app create edit merge and more open any type of file",
                fontSize = 15.sp,
                color = Color(android.graphics.Color.parseColor("#6C7278")),
                fontFamily = urbanist_regular,
                textAlign = TextAlign.Center
            )
        }
    }
}