package com.dagger.main.di

import com.dagger.coreutils.DaggerComponent
import com.dagger.coreutils.FlowNavigationModule
import com.dagger.coreutils.PerFlow
import com.dagger.main.MainFlowFragment
import dagger.Component

@PerFlow
@Component(
    modules = [FlowNavigationModule::class],
    dependencies = [MainFlowDependencies::class]
)
interface MainFlowComponent : DaggerComponent {
    fun inject(fragment: MainFlowFragment)

}