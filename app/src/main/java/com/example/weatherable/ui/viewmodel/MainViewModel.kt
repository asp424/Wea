package com.example.weatherable.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.weatherable.data.repository.Repository
import com.example.weatherable.data.view_states.InternetResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) :
    ViewModel(),
    LifecycleObserver {
    private val _internetValues: MutableStateFlow<InternetResponse?> =
        MutableStateFlow(InternetResponse.Loading)
    val internetValues = _internetValues.asStateFlow()
    private var intJob: Job? = null
    @RequiresApi(Build.VERSION_CODES.M)
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun getJsoupData() {
        intJob?.cancel()
        intJob = viewModelScope.launch {
            repository.getJsoupData().collect {
                _internetValues.value = it
            }
        }
        intJob?.start()
    }
    fun stop() {
        intJob?.cancel()
    }
    }