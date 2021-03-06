package com.chadmarchand.forgeofhistory.component

import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import com.artemis.io.JsonArtemisSerializer
import com.artemis.managers.WorldSerializationManager
import com.chadmarchand.forgeofhistory.ai.AiSystem
import com.chadmarchand.forgeofhistory.world.EconomySystem
import org.koin.java.KoinJavaComponent.inject

internal fun createArtemisWorld(): World {
    val serializationManager: WorldSerializationManager by inject(WorldSerializationManager::class.java)

    val config = WorldConfigurationBuilder()
        .with(
            serializationManager,
            EconomySystem(),
            AiSystem()
        ).build()
    val world = World(config)
    serializationManager.setSerializer(JsonArtemisSerializer(world))
    return world
}
