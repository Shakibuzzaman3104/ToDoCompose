package com.diatomicsoft.todocompose.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diatomicsoft.todocompose.core.localdb.MyRoomDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val roomDatabase: MyRoomDatabase
) : ViewModel() {

    private var _isTasksAvailable: MutableStateFlow<Unit> = MutableStateFlow(Unit)
    val isTasksAvailable: StateFlow<Boolean> = _isTasksAvailable.flatMapLatest {
        roomDatabase.taskDao().hasTasks()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    init {
        _isTasksAvailable.tryEmit(Unit)
    }

}