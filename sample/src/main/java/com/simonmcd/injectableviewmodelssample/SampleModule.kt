package com.simonmcd.injectableviewmodelssample

import androidx.lifecycle.ViewModel
import com.simonmcd.injectableviewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SampleModule {

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    fun bindSampleViewModel(sampleViewModel: SampleViewModel): ViewModel
}