package com.dagger.newdagger.di

import android.content.Context
import com.dagger.coreutils.ComponentDependencies
import com.dagger.coreutils.ComponentDependenciesKey
import com.dagger.main.di.MainFlowDependencies
import com.dagger.newdagger.App
import com.dagger.newdagger.MainActivity
import dagger.*
import dagger.multibindings.IntoMap
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ComponentDependenciesModule::class,
    NavigationModule::class]
)
interface AppComponent : MainFlowDependencies  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}

@Module
object AppModule {

}

@Module
object NavigationModule {
    @Provides
    @JvmStatic
    @Singleton
    fun provideCicerone() = Cicerone.create()

    @Provides
    @JvmStatic
    @Singleton
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    @JvmStatic
    @Singleton
    fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder
}

@Module
interface ComponentDependenciesModule {
    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainFlowDependencies::class)
    fun provideMainFlowDependencies(app: AppComponent): ComponentDependencies
}

