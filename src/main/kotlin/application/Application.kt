package com.chadmarchand.forgeofnations.application

import com.chadmarchand.forgeofnations.engine.Engine
import com.chadmarchand.forgeofnations.koin.initializeKoin

object Application {
    @JvmStatic
    fun main(arg: Array<String>) {
        initializeKoin()

        val engine = Engine()
        engine.initialize()
    }
}
