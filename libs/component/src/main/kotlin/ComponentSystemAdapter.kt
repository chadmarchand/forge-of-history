package com.chadmarchand.forgeofhistory.component

import com.artemis.Aspect
import com.artemis.World
import com.artemis.io.SaveFileFormat
import com.artemis.managers.WorldSerializationManager
import com.chadmarchand.forgeofhistory.ai.AiControllerComponent
import com.chadmarchand.forgeofhistory.save.COMPONENT_STATE_METADATA_FIELD
import com.chadmarchand.forgeofhistory.save.LoadGameEvent
import com.chadmarchand.forgeofhistory.save.SaveGameEvent
import com.chadmarchand.forgeofhistory.save.SaveGameMetadataService
import com.chadmarchand.forgeofhistory.world.StockpileComponent
import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.event.OnEvent
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.ByteArrayOutputStream
import java.lang.RuntimeException

private val logger = KotlinLogging.logger {}

class ComponentSystemAdapter : KoinComponent {
    private val world: World by inject()
    private val serializationManager: WorldSerializationManager by inject()
    private val saveGameMetadataService: SaveGameMetadataService by inject()
    private val eventBus: EventBus by inject()

    init {
        eventBus.registerSubscriber(this)
    }

    @OnEvent(SaveGameEvent::class)
    fun handleComponentSystemSaveEvent(event: SaveGameEvent) {
        saveGameMetadataService.setMetadataField(
            COMPONENT_STATE_METADATA_FIELD,
            getArtemisStateAsString()
        )
    }

    @OnEvent(LoadGameEvent::class)
    fun handleComponentSystemLoadEvent(event: LoadGameEvent) {
        logger.debug("Handling LoadGameEvent")

        logger.debug("Deleting existing Artemis entities")
        val entities = world.aspectSubscriptionManager.get(Aspect.all()).entities
        for (i in 0 until entities.size()) {
            world.delete(i)
        }
        world.entityManager.reset()

        logger.debug("Loading Artemis entity JSON string")
        val serializedWorldJson = saveGameMetadataService.getMetadataField(
            COMPONENT_STATE_METADATA_FIELD
        ).orElseThrow { RuntimeException("Expected component world JSON to be loaded") }
        serializationManager.load(serializedWorldJson.fieldValue!!.byteInputStream(), SaveFileFormat::class.java)
        logger.debug("Loaded JSON data into Artemis world")
    }

    fun initialize() {
        // Temporarily add entities for testing purposes
        val entityId = world.create()
        world.edit(entityId).create(StockpileComponent::class.java).money = 2000.0
        world.edit(entityId).create(AiControllerComponent::class.java)

        val entityId2 = world.create()
        world.edit(entityId2).create(StockpileComponent::class.java).money = 3000.0
        world.edit(entityId2).create(AiControllerComponent::class.java)
    }

    private fun getArtemisStateAsString(): String {
        val bos = ByteArrayOutputStream()
        serializationManager.save(bos, SaveFileFormat(world.aspectSubscriptionManager.get(Aspect.all())))
        return String(bos.toByteArray())
    }

    fun loop() {
        world.process()
    }
}
