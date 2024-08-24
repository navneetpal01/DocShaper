package com.app.docshaper.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme()

private val LightColorScheme = lightColorScheme()

private val AmoledDarkColors = darkColorScheme()

@Composable
fun DocShaperTheme(
    darkMode: Boolean?,
    amoledMode: Boolean,
    dynamicTheming: Boolean,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val isDarkMode = isDarkMode(darkMode = darkMode)
    val isDynamicTheming = isDynamicTheming(dynamicTheming = dynamicTheming)
    val dynamicThemingSupported = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors = when {
        isDynamicTheming && dynamicThemingSupported && isDarkMode -> dynamicDarkColorScheme(context)
        isDynamicTheming && dynamicThemingSupported && !isDarkMode -> dynamicLightColorScheme(
            context
        )

        isDarkMode && amoledMode -> AmoledDarkColors
        isDarkMode && !amoledMode -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )

}


@Composable
private fun isDarkMode(darkMode: Boolean?): Boolean {
    return when (darkMode) {
        true -> true
        false -> false
        else -> isSystemInDarkTheme()
    }
}

@Composable
private fun isDynamicTheming(dynamicTheming: Boolean): Boolean {
    return when (dynamicTheming) {
        true -> true
        false -> false
    }
}