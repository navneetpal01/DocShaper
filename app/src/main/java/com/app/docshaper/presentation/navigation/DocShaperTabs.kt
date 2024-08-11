package com.app.docshaper.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.docshaper.R


enum class DocShaperTabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: DocShaperRoute
) {
    Home(title = R.string.screen_home, icon = R.drawable.ic_launcher_foreground, route = DocShaperRoute.Home),
    Files(title = R.string.screen_files, icon = R.drawable.ic_launcher_foreground, route = DocShaperRoute.Files),
    Search(title = R.string.screen_search, icon = R.drawable.ic_launcher_foreground, route = DocShaperRoute.Search)
}