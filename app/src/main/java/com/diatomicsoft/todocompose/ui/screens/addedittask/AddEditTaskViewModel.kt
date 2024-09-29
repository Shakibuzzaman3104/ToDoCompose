package com.diatomicsoft.todocompose.ui.screens.addedittask

import android.util.Log
import androidx.lifecycle.ViewModel
import com.diatomicsoft.todocompose.core.localdb.dao.TasksDao
import com.diatomicsoft.todocompose.data.model.ModelTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEditTaskViewModel @Inject constructor(private val tasksDao: TasksDao) : ViewModel() {

    private val _isTaskAdded = MutableStateFlow(0L)
    val isTaskAdded = _isTaskAdded

    fun addTask(title: String, description: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val task = ModelTask(title = title, description = description ?: "")
            val status = tasksDao.insertTask(task)
            Log.d("Insertion", "addTask: ")
            isTaskAdded.tryEmit(status)
        }
    }

    fun updateTask(task: ModelTask) {
        CoroutineScope(Dispatchers.IO).launch {
            tasksDao.insertTask(task)
        }
    }

    fun getTaskById(taskId: Int) = CoroutineScope(Dispatchers.IO).launch {
        tasksDao.getTaskById(taskId)
    }

}