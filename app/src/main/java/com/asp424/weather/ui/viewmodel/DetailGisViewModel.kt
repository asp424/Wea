package com.asp424.weather.ui.viewmodel

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asp424.weather.data.repository.Repository
import com.asp424.weather.data.view_states.InternetResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailGisViewModel @Inject constructor(private val repository: Repository) : ViewModel(),
    DefaultLifecycleObserver {
    private val _internetValues: MutableStateFlow<InternetResponse?> =
        MutableStateFlow(InternetResponse.Loading)
    val internetValues = _internetValues.asStateFlow()

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        getGisData(owner as Context)
    }
    private fun getGisData(context: Context) {
        viewModelScope.launch {
            repository.getGisData(context).collect {
                _internetValues.value = it
            }
        }
    }
    }