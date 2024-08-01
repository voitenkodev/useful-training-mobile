package user.mapping

import models.ExperienceEnum

public fun ExperienceEnum.toExperienceEnumState(): user.ExperienceEnum {
    return when (this) {
        ExperienceEnum.BEGINNER -> user.ExperienceEnum.BEGINNER
        ExperienceEnum.INTERMEDIATE -> user.ExperienceEnum.INTERMEDIATE
        ExperienceEnum.ADVANCED -> user.ExperienceEnum.ADVANCED
        ExperienceEnum.PRO -> user.ExperienceEnum.PRO
        ExperienceEnum.UNKNOWN -> user.ExperienceEnum.BEGINNER
    }
}