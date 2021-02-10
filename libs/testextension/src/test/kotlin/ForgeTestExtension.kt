package com.chadmarchand.forgeofhistory.testextension

import org.koin.core.module.Module
import com.chadmarchand.kutna.persistence.KutnaTestSetupExtensionPersistent

class ForgeTestExtension constructor(
    koinModules: List<Module>
): KutnaTestSetupExtensionPersistent(
    koinModules,
    listOf(
        "filesystem:../world/src/main/resources/db/migration",
        "filesystem:src/main/resources/db/migration"
    )
)
