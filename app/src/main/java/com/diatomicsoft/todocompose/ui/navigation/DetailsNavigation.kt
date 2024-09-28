package com.diatomicsoft.todocompose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.diatomicsoft.todocompose.navigation.NavigationDestination
import com.diatomicsoft.todocompose.ui.screens.details.DetailsScreen
import kotlinx.serialization.Serializable


@Serializable
object DetailsNavigation

fun NavController.navigateToFoodDelivery() =
    navigate(route = DetailsNavigation)

fun NavGraphBuilder.detailsScreen(
    navigator: (NavigationDestination) -> Unit
) {
    composable<DetailsNavigation>(
     /*   deepLinks = listOf(
            navDeepLink {
                uriPattern = "https://www.example.com/bookmarks/{newsResourceId}"
            },
        ),*/
    ) {
        DetailsScreen(
            navigate = navigator
        )
    }
}