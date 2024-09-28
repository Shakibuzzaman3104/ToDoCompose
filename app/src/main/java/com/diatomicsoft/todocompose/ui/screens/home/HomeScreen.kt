package com.diatomicsoft.todocompose.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.reflect.KClass

@Composable
internal fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    navigator: (KClass<*>) -> Unit
) {
    HomeScreen(
        modifier = modifier,
        navigator = navigator
    )
}

@Composable
fun HomeScreen(modifier: Modifier, navigator: (KClass<*>) -> Unit) {

}