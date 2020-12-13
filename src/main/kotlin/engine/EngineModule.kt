package com.chadmarchand.forgeofnations.engine

import org.koin.dsl.module
import org.koin.experimental.builder.single

val engineModule = module(createdAtStart = true) {
    single<Engine>()
    single<EngineService>()
}
