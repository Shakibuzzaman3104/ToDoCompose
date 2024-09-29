package com.diatomicsoft.todocompose.ui.screens.addedittask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.diatomicsoft.todocompose.ui.theme.FontStyle
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
internal fun AddEditTaskRoute(
    modifier: Modifier = Modifier,
    close: () -> Unit,
    taskId: Int? = null,
    viewModel: AddEditTaskViewModel = hiltViewModel()
) {

    val snackbarHostState = remember { SnackbarHostState() }

    DialogAddEditTask(
        modifier = modifier,
        close = close,
        addTask = viewModel::addTask,
        taskId = taskId,
        snackbarHostState
    )

}

@Composable
fun DialogAddEditTask(
    modifier: Modifier = Modifier,
    close: () -> Unit,
    addTask: (String, String?) -> Unit,
    taskId: Int? = null,
    snackbarHostState: SnackbarHostState // Pass ScaffoldState from the parent
) {

    var isTaskAdded by remember { mutableStateOf(false) }
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope() // For showing snackbar

    Dialog(onDismissRequest = { close() }) {
        Card(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {

                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (taskId == null) "Add Task" else "Update Task",
                        style = FontStyle.titleLarge
                    )
                    IconButton(onClick = {
                        close()
                    }) {
                        Icon(
                            Icons.Filled.Close,
                            contentDescription = "Close",
                            Modifier.padding(0.dp)
                        )
                    }
                }

                OutlinedTextField(
                    value = taskTitle,
                    onValueChange = { taskTitle = it },
                    label = { Text("Title") },
                    placeholder = { Text("Enter task title") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = taskDescription,
                    onValueChange = {
                        taskDescription = it
                    },
                    label = { Text("Description") },
                    placeholder = { Text("Enter task description") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        addTask(taskTitle, taskDescription)
                        isTaskAdded = true
                        close()
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 48.dp),
                ) {
                    Text(text = if (taskId == null) "Add Task" else "Update Task")
                }
            }
        }
    }

    // If you want to trigger snackbar based on isTaskAdded flag
    LaunchedEffect(isTaskAdded) {
        if (isTaskAdded) {
            scope.launch {
                snackbarHostState.showSnackbar(
                    message = "Task ${if (taskId == null) "added" else "updated"} successfully!"
                )
            }
        }
    }
}


fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(millis)
}

@Preview(showBackground = true)
@Composable
fun DialogAddEditTaskPreview() {
    /*  DialogAddEditTask(close = {}, addTask = { title, des,  ->

      })*/
}