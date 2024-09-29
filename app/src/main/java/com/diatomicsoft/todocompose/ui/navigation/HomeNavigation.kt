package com.diatomicsoft.todocompose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.diatomicsoft.todocompose.navigation.NavigationDestination
import com.diatomicsoft.todocompose.ui.screens.home.HomeScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

fun NavController.navigateToHome() =
    navigate(route = HomeScreenRoute)

fun NavGraphBuilder.homeScreen(
    navigator: (NavigationDestination) -> Unit
) {
    composable<HomeScreenRoute> {
        HomeScreenRoute(navigator = navigator)
    }
}