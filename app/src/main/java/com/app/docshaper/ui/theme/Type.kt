package com.app.docshaper.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.docshaper.R


val urbanist_medium = FontFamily(Font(R.font.urbanist_medium))
val urbanist_regular = FontFamily(Font(R.font.urbanist_regular))


// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = urbanist_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 60.sp,
        lineHeight = 43.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = urbanist_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 42.sp,
        lineHeight = 30.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = urbanist_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        lineHeight = 23.sp
    ),

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)