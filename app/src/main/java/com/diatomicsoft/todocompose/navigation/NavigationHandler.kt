package com.diatomicsoft.todocompose.navigation

import androidx.navigation.NavController
import com.diatomicsoft.todocompose.ui.navigation.navigateToAddEditTask


fun NavController.gotoDestination(destination: NavigationDestination) {
    when (destination) {

        //<editor-fold desc="HomeScreen">
        is NavigationDestination.ActionHomeToTaskDetails -> {
        }
        //</editor-fold>

        //<editor-fold desc="EmptyScreen">
        is NavigationDestination.ActionEmptyScreenToAddEditTaskDialog -> {
            navigateToAddEditTask(destination.taskId)
        }
        //</editor-fold>
    }
}
