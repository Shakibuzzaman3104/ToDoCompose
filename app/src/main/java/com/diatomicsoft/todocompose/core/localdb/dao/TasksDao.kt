package com.diatomicsoft.todocompose.core.localdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diatomicsoft.todocompose.data.model.ModelTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): Flow<List<ModelTask>>

    @Query("SELECT * FROM task_table WHERE id = :id")
    fun getTaskById(id: Int): Flow<ModelTask>

    @Query("SELECT * FROM task_table WHERE isFinished = 0")
    fun getIncompleteTasks(): Flow<List<ModelTask>>

    @Query("SELECT * FROM task_table WHERE isFinished = 1")
    fun getCompletedTasks(): Flow<List<ModelTask>>

    @Query("SELECT * FROM task_table WHERE title LIKE '%' || :searchQuery || '%'")
    fun searchTasks(searchQuery: String): Flow<List<ModelTask>>

    @Query("SELECT EXISTS(SELECT 1 FROM task_table LIMIT 1)")
    fun hasTasks(): Flow<Boolean>

    @Delete
    suspend fun deleteTask(task: ModelTask)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: ModelTask): Long


}