package com.asp424.weather.di.dagger_2.models.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.asp424.weather.ui.viewmodel.viewmodel_factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module(includes = [ViewModelModules::class])
interface ViewModelFactoryModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}