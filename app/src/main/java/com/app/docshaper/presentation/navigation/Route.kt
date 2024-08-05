package com.app.docshaper.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object OnBoarding

@Serializable
object Tabs

@Serializable
object Settings

@Serializable
sealed class DocShaperTabs{
    @Serializable
    object Home : DocShaperTabs()

    @Serializable
    object Files : DocShaperTabs()

    @Serializable
    object Search : DocShaperTabs()
}