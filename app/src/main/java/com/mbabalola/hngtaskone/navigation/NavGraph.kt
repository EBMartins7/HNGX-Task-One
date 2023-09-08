package com.mbabalola.hngtaskone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mbabalola.hngtaskone.Screen
import com.mbabalola.hngtaskone.screens.GithubScreen
import com.mbabalola.hngtaskone.screens.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.GitHubScreen.route) {
            GithubScreen(navController = navController)
        }
    }
}
