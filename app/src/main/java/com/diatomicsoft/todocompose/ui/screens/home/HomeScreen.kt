package com.diatomicsoft.todocompose.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diatomicsoft.todocompose.navigation.NavigationDestination
import kotlin.reflect.KClass

@Composable
internal fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    navigator: (NavigationDestination) -> Unit
) {
    HomeScreen(
        modifier = modifier,
        navigator = navigator
    )
}

@Composable
fun HomeScreen(modifier: Modifier, navigator: (NavigationDestination) -> Unit) {

}