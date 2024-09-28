package com.diatomicsoft.todocompose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.diatomicsoft.todocompose.ui.screens.home.HomeScreenRoute
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
object HomeScreenRoute

fun NavController.navigateToHome() =
    navigate(route = HomeScreenRoute)

fun NavGraphBuilder.homeScreen(
    navigator: (KClass<*>) -> Unit
) {
    composable(route = HomeScreenRoute.toString()) {
        HomeScreenRoute(navigator = navigator)
    }
}