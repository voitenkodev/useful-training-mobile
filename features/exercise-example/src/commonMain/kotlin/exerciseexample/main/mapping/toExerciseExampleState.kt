package exerciseexample.main.mapping

import exerciseexample.main.models.Category
import exerciseexample.main.models.ExerciseExample
import exerciseexample.main.models.Experience
import exerciseexample.main.models.ForceType
import exerciseexample.main.models.WeightType
import models.CategoryEnum
import models.ExperienceEnum
import models.WeightTypeEnum

internal fun models.ExerciseExample.toState(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        exerciseExampleBundles = exerciseExampleBundles.toState(),
        equipments = equipments.toState(),
        experience = experience.toState(),
        forceType = forceType.toState(),
        weightType = weightType.toState(),
        category = category.toState()
    )
}

private fun WeightTypeEnum.toState(): WeightType? {
    return when (this) {
        WeightTypeEnum.FREE -> WeightType.FREE
        WeightTypeEnum.FIXED -> WeightType.FIXED
        else -> null
    }
}

private fun CategoryEnum.toState(): Category? {
    return when (this) {
        CategoryEnum.COMPOUND -> Category.COMPOUND
        CategoryEnum.ISOLATION -> Category.ISOLATION
        else -> null
    }
}

private fun ExperienceEnum.toState(): Experience? {
    return when (this) {
        ExperienceEnum.BEGINNER -> Experience.BEGINNER
        ExperienceEnum.INTERMEDIATE -> Experience.INTERMEDIATE
        ExperienceEnum.ADVANCED -> Experience.ADVANCED
        ExperienceEnum.PRO -> Experience.PRO
        else -> null
    }
}

private fun models.ForceTypeEnum.toState(): ForceType? {
    return when (this) {
        models.ForceTypeEnum.PULL -> ForceType.PULL
        models.ForceTypeEnum.PUSH -> ForceType.PUSH
        else -> null
    }
}