package com.chadmarchand.forgeofhistory.save

import com.chadmarchand.kutna.event.EventBus
import io.github.classgraph.ClassGraph
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.jdbc.core.JdbcTemplate

private val logger = KotlinLogging.logger {}

class SaveGameService : KoinComponent {
    private val jdbcTemplate: JdbcTemplate by inject()
    private val eventBus: EventBus by inject()

    fun saveGame() {
        val tablesString = getCommaDelimitedTablesToSave()

        logger.debug("Publishing SaveGameEvent")
        eventBus.publish(SaveGameEvent())

        logger.debug("Saving game with tables $tablesString")
        jdbcTemplate.execute("SCRIPT TO 'savegames/quicksave.sql' TABLE ${tablesString};") {
            it.execute()
            logger.debug("GOT RESULT FROM SQL ${it}")
        }
    }

    fun loadGame() {
        logger.debug("Loading quicksave")
        jdbcTemplate.execute("DROP ALL OBJECTS; RUNSCRIPT FROM 'savegames/quicksave.sql'")
        eventBus.publish(LoadGameEvent())
    }

    private fun getCommaDelimitedTablesToSave(): String {
        var tablesString = ""

        logger.debug("Finding annotated classes to save")
        val pkg = "com.chadmarchand.forgeofhistory"
        val routeAnnotation = "com.chadmarchand.forgeofhistory.save.DynamicEntity"
        ClassGraph()
            .enableAllInfo()
            .acceptPackages(pkg)
            .scan().use { scanResult ->
                for (routeClassInfo in scanResult.getClassesWithAnnotation(routeAnnotation)) {
                    logger.debug("Found class with dynamic annotation - ${routeClassInfo.simpleName}")

                    tablesString = if (tablesString !== "") {
                        tablesString + ", ${routeClassInfo.simpleName}"
                    } else {
                        routeClassInfo.simpleName
                    }
                }
            }

        if (tablesString == "") {
            throw RuntimeException("Expected at least one class with dynamic annotation to be found, but none were")
        }

        return tablesString
    }
}
