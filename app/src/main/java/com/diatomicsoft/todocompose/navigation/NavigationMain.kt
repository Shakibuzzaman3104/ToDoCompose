package com.diatomicsoft.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.diatomicsoft.todocompose.ui.navigation.EmptyScreenRoute
import com.diatomicsoft.todocompose.ui.navigation.HomeScreenRoute
import com.diatomicsoft.todocompose.ui.navigation.addEditDialog
import com.diatomicsoft.todocompose.ui.navigation.detailsScreen
import com.diatomicsoft.todocompose.ui.navigation.emptyScreenNavigation
import com.diatomicsoft.todocompose.ui.navigation.homeScreen

@Composable
fun NavigationMain(navController: NavHostController, isTodoListAvailable: Boolean = false) {
    NavHost(
        navController,
        startDestination = if (isTodoListAvailable) HomeScreenRoute else EmptyScreenRoute
    ) {
        homeScreen {
            navController.navigate(it)
        }
        detailsScreen {
            navController.navigate(it)
        }

        emptyScreenNavigation {
            navController.gotoDestination(it)
        }
        addEditDialog(
            close = { navController.popBackStack() },
        )

    }

}