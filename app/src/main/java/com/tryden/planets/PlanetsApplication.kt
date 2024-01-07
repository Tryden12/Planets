package com.tryden.planets

import android.app.Application
import com.tryden.planets.di.AppContainer
import com.tryden.planets.di.DefaultAppContainer

class PlanetsApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}