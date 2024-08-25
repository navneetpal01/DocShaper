package com.app.docshaper.presentation.onboarding_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.docshaper.R
import com.app.docshaper.presentation.domain.OnBoardingTab
import com.app.docshaper.ui.theme.urbanist_bold
import com.app.docshaper.ui.theme.urbanist_regular


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier, pagerState: PagerState
) {

    val list = remember {
        listOf(
            OnBoardingTab(
                image = R.drawable.onboarding_1,
                title = R.string.onboarding01_title,
                description = R.string.onboarding01_description
            ), OnBoardingTab(
                image = R.drawable.onboarding_2,
                title = R.string.onboarding02_title,
                description = R.string.onboarding02_description
            ), OnBoardingTab(
                image = R.drawable.onboarding_3,
                title = R.string.onboarding03_title,
                description = R.string.onboarding03_description
            )
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            userScrollEnabled = false,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(list[it].image),
                contentScale = ContentScale.Fit,
                contentDescription = "onboarding_image"
            )
        }
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
                text = stringResource(id = list[pagerState.currentPage].title),
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
                text = stringResource(id = list[pagerState.currentPage].description),
                fontSize = 15.sp,
                color = Color(android.graphics.Color.parseColor("#6C7278")),
                fontFamily = urbanist_regular,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 5
            )
        }
    }
}

