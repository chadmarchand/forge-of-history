package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.forgeofhistory.save.DynamicEntity
import com.chadmarchand.kutna.common.types.DEFAULT_ID
import com.chadmarchand.kutna.common.types.Id
import com.chadmarchand.kutna.persistence.field.Persist
import com.chadmarchand.kutna.persistence.field.PrimaryId

@DynamicEntity
data class Technology (
    @Persist
    @PrimaryId
    var id: Id = Id.DEFAULT_ID,

    @Persist
    var name: String? = null
)
