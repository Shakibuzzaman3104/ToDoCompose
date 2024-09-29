package com.diatomicsoft.todocompose.core.di

import android.content.Context
import androidx.room.Room
import com.diatomicsoft.todocompose.core.localdb.MyRoomDatabase
import com.diatomicsoft.todocompose.core.localdb.dao.TasksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): MyRoomDatabase {
        return Room.databaseBuilder(
            context,
            MyRoomDatabase::class.java,
            "todo_database"
        ).build()
    }


        @Provides
        fun provideTaskDao(db: MyRoomDatabase): TasksDao = db.taskDao()

}