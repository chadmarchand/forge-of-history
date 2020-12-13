package com.chadmarchand.forgeofnations.koin

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initializeKoin() = initializeKoin(null)

fun initializeKoin(additionalModules: List<Module>?): KoinApplication {
    var modulesToUse = koinModules

    if (additionalModules != null) {
        modulesToUse = listOf(*(additionalModules.toTypedArray()), *koinModules.toTypedArray())
    }

    return startKoin {
        modules(modulesToUse as List<Module>)
    }
}
