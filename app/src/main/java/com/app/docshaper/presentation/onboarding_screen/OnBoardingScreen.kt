package com.app.docshaper.presentation.onboarding_screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.docshaper.R
import com.app.docshaper.presentation.domain.OnBoardingTab
import com.app.docshaper.presentation.onboarding_screen.components.OnBoardingBottom
import com.app.docshaper.presentation.onboarding_screen.components.OnBoardingPage
import com.app.docshaper.presentation.settings_screen.SettingsEvent
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    onCompleted: (SettingsEvent) -> Unit
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

    val pagerState = rememberPagerState(initialPage = 0) {
        list.size
    }
    val scope = rememberCoroutineScope()


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            OnBoardingBottom(
                pagerState = pagerState,
                onSkip = {
                    scope.launch {
                        pagerState.animateScrollToPage(list.lastIndex)
                    }
                },
                onNext = {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            onCompleted(SettingsEvent.SetFirstLaunch)
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            )
        },
        contentWindowInsets = WindowInsets(top = 0),
        containerColor = Color.White
    ) { paddingValues ->
        OnBoardingPage(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            pagerState = pagerState,
            list = list
        )
    }
}