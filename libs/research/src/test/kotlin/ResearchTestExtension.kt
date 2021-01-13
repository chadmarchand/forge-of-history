package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.kutna.event.EventBus
import com.chadmarchand.kutna.persistence.KutnaTestSetupExtensionPersistent
import com.chadmarchand.kutna.persistence.persistenceModule
import org.koin.dsl.module
import org.koin.experimental.builder.single

class ResearchTestExtension : KutnaTestSetupExtensionPersistent(
    listOf(
        persistenceModule,
        researchModule,
        module { single<EventBus>() }
    )
)
