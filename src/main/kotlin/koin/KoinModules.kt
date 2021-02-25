package com.chadmarchand.forgeofhistory.koin

import com.chadmarchand.forgeofhistory.clock.clockModule
import com.chadmarchand.forgeofhistory.component.componentModule
import com.chadmarchand.forgeofhistory.engine.engineModule
import com.chadmarchand.forgeofhistory.research.researchModule
import com.chadmarchand.forgeofhistory.world.worldModule
import com.chadmarchand.kutna.event.EventBus
import org.koin.dsl.module
import org.koin.experimental.builder.single

private val eventModule = module { single<EventBus>() }

internal val koinModules = listOf(
    componentModule,
    engineModule,
    worldModule,
    clockModule,
    eventModule,
    researchModule
)
