package authentication.register.mapping

import authentication.register.models.ExperienceEnum

internal fun ExperienceEnum.toExperienceEnumDomain(): models.ExperienceEnum {
    return when (this) {
        ExperienceEnum.BEGINNER -> models.ExperienceEnum.BEGINNER
        ExperienceEnum.INTERMEDIATE -> models.ExperienceEnum.INTERMEDIATE
        ExperienceEnum.ADVANCED -> models.ExperienceEnum.ADVANCED
        ExperienceEnum.PRO -> models.ExperienceEnum.PRO
    }
}