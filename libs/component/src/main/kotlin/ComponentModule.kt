package com.chadmarchand.forgeofhistory.component

import com.artemis.managers.WorldSerializationManager
import org.koin.dsl.module
import org.koin.experimental.builder.single

val componentModule = module(createdAtStart = true) {
    single<ComponentSystemAdapter>()
    single { createArtemisWorld() }
    single { WorldSerializationManager() }
}
