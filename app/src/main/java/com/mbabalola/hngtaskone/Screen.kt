package com.mbabalola.hngtaskone

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object GitHubScreen : Screen("github_screen")
}