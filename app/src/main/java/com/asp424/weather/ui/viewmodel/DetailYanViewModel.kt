package com.asp424.weather.ui.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.asp424.weather.data.repository.Repository
import com.asp424.weather.data.view_states.InternetResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailYanViewModel @Inject constructor(private val repository: Repository) : ViewModel(), DefaultLifecycleObserver {
    private val _internetValues: MutableStateFlow<InternetResponse?> =
            MutableStateFlow(InternetResponse.Loading)
        val internetValues = _internetValues.asStateFlow()
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        getYanData(owner as Context)
    }
        private fun getYanData(context: Context) {
            viewModelScope.launch {
                repository.getYanData(context).collect {
                    _internetValues.value = it
                }
            }
        }
}