package com.gojek.daggermultimodulefeature

import android.app.Application
import com.gojek.daggermultimodulefeature.di.ApplicationComponent
import com.gojek.daggermultimodulefeature.di.DaggerApplicationComponent

class MainApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }
}