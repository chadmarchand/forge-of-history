package com.chadmarchand.forgeofhistory.component

import com.chadmarchand.forgeofhistory.world.EconomySystem
import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import com.chadmarchand.forgeofhistory.ai.AiSystem

internal fun createArtemisWorld(): World {
    val config = WorldConfigurationBuilder()
        .with(
            EconomySystem(),
            AiSystem()
        ).build()
    return World(config)
}
