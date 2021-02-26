package com.chadmarchand.forgeofhistory.research

import com.chadmarchand.kutna.common.types.DEFAULT_ID
import com.chadmarchand.kutna.common.types.Id
import com.chadmarchand.kutna.persistence.field.Persist
import com.chadmarchand.kutna.persistence.field.PrimaryId

data class ResearchProject(
    @PrimaryId
    @Persist
    var id: Id = Id.DEFAULT_ID,

    @Persist
    var entityId: Int = -1,

    @Persist
    var technologyId: Id? = null,

    @Persist
    var progress: Double? = 0.0,

    @Persist
    var isComplete: Boolean = false
) {
    companion object {
        fun of(entityId: Int, technologyId: Id): ResearchProject {
            return ResearchProject(
                entityId = entityId,
                technologyId = technologyId
            )
        }
    }
}
