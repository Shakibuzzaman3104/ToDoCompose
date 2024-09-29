package com.diatomicsoft.todocompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class ModelTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Int = 0,
    var isFinished: Boolean = false
)