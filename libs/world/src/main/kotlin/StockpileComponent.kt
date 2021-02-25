package com.chadmarchand.forgeofhistory.world

import com.artemis.Component
import com.chadmarchand.kutna.common.types.DEFAULT_ID
import com.chadmarchand.kutna.common.types.Id
import com.chadmarchand.kutna.persistence.field.Persist
import com.chadmarchand.kutna.persistence.field.PrimaryId

class StockpileComponent(
    @PrimaryId
    @Persist
    var id: Id = Id.DEFAULT_ID,

    @Persist
    var money: Double = 0.0
) : Component()
