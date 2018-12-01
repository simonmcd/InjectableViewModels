package com.simonmcd.injectableviewmodelssample

import com.simonmcd.injectableviewmodels.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        SampleModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)
    fun inject(sampleFragment: SampleFragment)
}