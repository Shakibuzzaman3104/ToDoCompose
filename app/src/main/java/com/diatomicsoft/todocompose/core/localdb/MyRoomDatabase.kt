package com.diatomicsoft.todocompose.core.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diatomicsoft.todocompose.core.localdb.dao.TasksDao
import com.diatomicsoft.todocompose.data.model.ModelTask

@Database(entities = [ModelTask::class], version = 1, exportSchema = false)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun taskDao(): TasksDao
}