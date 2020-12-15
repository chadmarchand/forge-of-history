package com.chadmarchand.forgeofnations.koin

import com.chadmarchand.forgeofnations.clock.clockModule
import com.chadmarchand.forgeofnations.engine.engineModule
import com.chadmarchand.forgeofnations.research.researchModule
import com.chadmarchand.kutna.event.EventBus
import org.koin.dsl.module
import org.koin.experimental.builder.single

private val eventModule = module { single<EventBus>() }

internal val koinModules = listOf(
    engineModule,
    clockModule,
    eventModule,
    researchModule
)
