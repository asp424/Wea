package com.asp424.weather.di.dagger_2.models.viewmodel

import androidx.lifecycle.ViewModel
import com.asp424.weather.ui.viewmodel.DetailGisViewModel
import com.asp424.weather.ui.viewmodel.DetailYanViewModel
import com.asp424.weather.ui.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
interface ViewModelModules {
    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(DetailGisViewModel::class)
    fun bindsDetailGisViewModel(viewModel: DetailGisViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(DetailYanViewModel::class)
    fun bindsDetailYanViewModel(viewModel: DetailYanViewModel): ViewModel
}