package com.chadmarchand.forgeofhistory.application

import com.chadmarchand.forgeofhistory.engine.Engine
import com.chadmarchand.forgeofhistory.koin.initializeKoin
import com.chadmarchand.kutna.persistence.migration.flywayMigrate
import com.chadmarchand.kutna.persistence.persistenceModule

object Application {
    @JvmStatic
    fun main(arg: Array<String>) {
        initializeKoin(
            listOf(persistenceModule)
        )
        flywayMigrate(listOf("db/migration"))

        val engine = Engine()
        engine.initialize()
    }
}
