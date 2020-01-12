package com.dagger.newdagger

import android.app.Application
import com.dagger.newdagger.di.AppComponent
import com.dagger.newdagger.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
        appComponent.inject(this)
    }
}