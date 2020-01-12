package com.dagger.coreutils

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFlow

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment