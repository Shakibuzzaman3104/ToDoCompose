package com.diatomicsoft.todocompose.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.diatomicsoft.todocompose.navigation.NavigationMain
import com.diatomicsoft.todocompose.ui.MainActivityViewModel

@Composable
fun ToDoApp(modifier: Modifier, viewModel: MainActivityViewModel) {
    val navController = rememberNavController()
    val isTodoListAvailable by viewModel.isTasksAvailable.collectAsStateWithLifecycle()
    NavigationMain(navController = navController, isTodoListAvailable = isTodoListAvailable)
}