package com.chadmarchand.forgeofnations.clock

import org.koin.dsl.module
import org.koin.experimental.builder.single

val clockModule = module {
    single<ClockController>()
    single<ClockService>()
    single<ClockStore>()
}
