package com.app.docshaper.presentation.onboarding_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.docshaper.presentation.onboarding_screen.components.OnBoardingBottom
import com.app.docshaper.presentation.settings_screen.SettingsEvent
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    onCompleted: (SettingsEvent) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 0) {
        3
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
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                onNext = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            )
        },
        contentWindowInsets = WindowInsets(top = 0),
        containerColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                userScrollEnabled = false,
            ) {

            }
        }
    }
}