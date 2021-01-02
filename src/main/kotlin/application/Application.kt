package com.chadmarchand.forgeofhistory.application

import com.chadmarchand.forgeofhistory.engine.Engine
import com.chadmarchand.forgeofhistory.koin.initializeKoin

object Application {
    @JvmStatic
    fun main(arg: Array<String>) {
        initializeKoin()

        val engine = Engine()
        engine.initialize()
    }
}
