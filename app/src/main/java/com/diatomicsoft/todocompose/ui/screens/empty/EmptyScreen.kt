package com.diatomicsoft.todocompose.ui.screens.empty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.diatomicsoft.todocompose.navigation.NavigationDestination
import com.diatomicsoft.todocompose.ui.theme.FontStyle

@Composable
internal fun EmptyScreenRoute(
    modifier: Modifier = Modifier,
    destination: (NavigationDestination) -> Unit
) {
    EmptyScreen(
        modifier = modifier,
        destination = destination
    )
}

@Composable
fun EmptyScreen(modifier: Modifier, destination: (NavigationDestination) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "No tasks available", style = FontStyle.titleLarge)
        Text(text = "Add a new task to get started", style = FontStyle.bodyLarge)

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(modifier = Modifier
            .height(48.dp)
            .width(48.dp)
            .clip(CircleShape)
            .background(color = Color.Black),
            onClick = {
                destination(NavigationDestination.ActionEmptyScreenToAddEditTaskDialog())
            }
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add task", tint = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun EmptyScreenPreview() {
    EmptyScreen(modifier = Modifier, destination = {})
}

