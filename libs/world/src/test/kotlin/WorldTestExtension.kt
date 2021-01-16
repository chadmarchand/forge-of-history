package com.chadmarchand.forgeofhistory.world

import com.chadmarchand.kutna.persistence.KutnaTestSetupExtensionPersistent
import com.chadmarchand.kutna.persistence.persistenceModule

class WorldTestExtension : KutnaTestSetupExtensionPersistent(
    listOf(
        persistenceModule,
        worldModule
    )
)
