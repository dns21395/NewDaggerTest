package com.dagger.main.di

import com.dagger.coreutils.ComponentDependencies
import ru.terrakok.cicerone.Router

interface MainFlowDependencies : ComponentDependencies {
    fun router(): Router
}