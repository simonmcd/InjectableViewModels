package com.simonmcd.injectableviewmodelssample

import android.app.Application

/**
 * Main Application class for the app.
 */
class App : Application() {

    companion object {

        lateinit var graph: AppComponent

        fun init(app: App) {
            graph = DaggerAppComponent.builder().build()
            graph.inject(app)
        }
    }

    override fun onCreate() {
        super.onCreate()
        init(this)
    }
}
