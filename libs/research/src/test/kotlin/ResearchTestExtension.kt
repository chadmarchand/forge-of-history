package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.forgeofhistory.ai.aiModule
import com.chadmarchand.forgeofhistory.world.worldModule
import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.persistence.KutnaTestSetupExtensionPersistent
import com.chadmarchand.kutna.persistence.persistenceModule
import org.koin.dsl.module
import org.koin.experimental.builder.single

class ResearchTestExtension : KutnaTestSetupExtensionPersistent(
    listOf(
        persistenceModule,
        aiModule,
        worldModule,
        researchModule,
        module { single<EventBus>() }
    ),
    listOf(
        "filesystem:../world/src/main/resources/db/migration",
        "filesystem:src/main/resources/db/migration"
    )
)
