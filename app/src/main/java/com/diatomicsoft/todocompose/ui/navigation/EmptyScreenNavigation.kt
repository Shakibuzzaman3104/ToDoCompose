package com.diatomicsoft.todocompose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.diatomicsoft.todocompose.navigation.NavigationDestination
import com.diatomicsoft.todocompose.ui.screens.empty.EmptyScreenRoute
import kotlinx.serialization.Serializable

@Serializable
object EmptyScreenRoute

fun NavController.navigateToEmptyScreen() =
    navigate(route = EmptyScreenRoute)

fun NavGraphBuilder.emptyScreenNavigation(
    navigator: (destination: NavigationDestination) -> Unit
) {
    composable<EmptyScreenRoute>(
        /*   deepLinks = listOf(
               navDeepLink {
                   uriPattern = "https://www.example.com/bookmarks/{newsResourceId}"
               },
           ),*/
    ) {
        EmptyScreenRoute(destination = navigator)
    }
}