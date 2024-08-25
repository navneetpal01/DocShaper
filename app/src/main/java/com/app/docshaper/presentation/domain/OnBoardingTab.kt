package com.app.docshaper.presentation.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingTab(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)