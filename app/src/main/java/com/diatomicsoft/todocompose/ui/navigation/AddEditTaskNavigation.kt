package com.diatomicsoft.todocompose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.diatomicsoft.todocompose.ui.screens.addedittask.AddEditTaskRoute
import com.diatomicsoft.todocompose.ui.screens.addedittask.DialogAddEditTask
import kotlinx.serialization.Serializable

@Serializable
data class AddEditTaskRoute(val taskId: Int? = null)



fun NavController.navigateToAddEditTask(taskId: Int? = null) =
    navigate(route = AddEditTaskRoute(taskId))

fun NavGraphBuilder.addEditDialog(
    close: () -> Unit,
) {
    composable<AddEditTaskRoute>(
        /*   deepLinks = listOf(
               navDeepLink {
                   uriPattern = "https://www.example.com/bookmarks/{newsResourceId}"
               },
           ),*/
    ) {
        val task: AddEditTaskRoute = it.toRoute()
        AddEditTaskRoute(close = close, taskId = task.taskId)
    }
}