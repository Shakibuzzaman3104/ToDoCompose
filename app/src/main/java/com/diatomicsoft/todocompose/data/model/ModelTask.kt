package com.diatomicsoft.todocompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class ModelTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val priority: Boolean,
    val date: String,
    val time: String,
    val isFinished: Boolean
)