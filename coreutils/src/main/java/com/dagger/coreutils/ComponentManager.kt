package com.dagger.coreutils

interface DaggerComponent

object ComponentManager {
    private val components = mutableMapOf<String, DaggerComponent>()

    fun getOrPutComponent(componentName: String, componentBuilder: () -> DaggerComponent) =
        components.getOrPut(componentName, componentBuilder)

    fun clearComponent(componentName: String) {
        components.remove(componentName)
    }
}