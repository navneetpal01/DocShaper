package com.app.docshaper.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object OnBoarding

@Serializable
object Tabs

@Serializable
object Settings

@Serializable
sealed class DocShaperRoute {
    @Serializable
    object Home : DocShaperRoute()

    @Serializable
    object Files : DocShaperRoute()

    @Serializable
    object Search : DocShaperRoute()
}

