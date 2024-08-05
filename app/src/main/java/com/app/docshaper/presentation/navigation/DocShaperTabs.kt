package com.app.docshaper.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.docshaper.R
import com.app.docshaper.presentation.files_screen.FilesScreen
import com.app.docshaper.presentation.home_screen.HomeScreen
import com.app.docshaper.presentation.search_screen.SearchScreen


fun NavGraphBuilder.tabs() {
    composable<DocShaperRoute.Home> {
        HomeScreen()
    }
    composable<DocShaperRoute.Files> {
        FilesScreen()
    }
    composable<DocShaperRoute.Search> {
        SearchScreen()
    }
}

enum class DocShaperTabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: DocShaperRoute
) {
    Home(title = R.string.screen_home, icon = R.drawable.ic_launcher_foreground, route = DocShaperRoute.Home),
    Files(title = R.string.screen_files, icon = R.drawable.ic_launcher_foreground, route = DocShaperRoute.Files),
    Search(title = R.string.screen_search, icon = R.drawable.ic_launcher_foreground, route = DocShaperRoute.Search)
}