package com.dagger.main

import android.os.Bundle
import android.util.Log
import com.dagger.coreutils.findComponentDependencies
import com.dagger.coreutils.ui.FlowFragment
import com.dagger.main.di.DaggerMainFlowComponent
import com.dagger.main.di.MainFlowComponent
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainFlowFragment : FlowFragment() {

    init {
        componentBuilder = {
            DaggerMainFlowComponent.builder().mainFlowDependencies(findComponentDependencies()).build()
        }
    }

    @Inject
    override lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        getComponent<MainFlowComponent>().inject(this)
        super.onCreate(savedInstanceState)
        Log.d("GTA5", "MainFlowFragment")
    }

    override fun onExit() {

    }
}