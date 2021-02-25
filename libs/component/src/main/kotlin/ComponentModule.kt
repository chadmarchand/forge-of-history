package com.chadmarchand.forgeofhistory.component

import org.koin.dsl.module
import org.koin.experimental.builder.single

val componentModule = module(createdAtStart = true) {
    single<ComponentSystemAdapter>()
    single { createArtemisWorld() }
}
