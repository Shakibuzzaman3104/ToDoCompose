package com.diatomicsoft.todocompose.navigation

sealed interface NavigationDestination {

    //<editor-fold desc="Home">
    data class ActionHomeToTaskDetails(val taskId: Int? = null) : NavigationDestination
    //</editor-fold>

    //<editor-fold desc="Empty Screen">
    data class ActionEmptyScreenToAddEditTaskDialog(val taskId: Int? = null) :
        NavigationDestination
    //</editor-fold>




}