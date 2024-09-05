package exercise.mapping

import equipment.mapping.toState
import exercise.Category
import exercise.ExerciseExample
import exercise.ForceType
import exercise.WeightType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import models.CategoryEnum
import models.ForceTypeEnum
import models.WeightTypeEnum
import user.mapping.toState

public fun List<models.ExerciseExample>.toState(): ImmutableList<ExerciseExample> {
    return map { it.toState() }
        .toImmutableList()
}

public fun models.ExerciseExample.toState(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        imageUrl = imageUrl,
        exerciseExampleBundles = exerciseExampleBundles.toState(),
        description = description ?: "",
        equipments = equipments.toState(),
        tutorials = tutorials.toState(),
        weightType = weightType.toState(),
        forceType = forceType.toState(),
        category = category.toState(),
        experience = experience.toState()
    )
}


private fun WeightTypeEnum.toState(): WeightType? {
    return when (this) {
        WeightTypeEnum.FREE -> WeightType.FREE
        WeightTypeEnum.FIXED -> WeightType.FIXED
        WeightTypeEnum.BODY_WEIGHT -> WeightType.BODY_WEIGHT
        WeightTypeEnum.UNKNOWN -> null
    }
}

private fun CategoryEnum.toState(): Category? {
    return when (this) {
        CategoryEnum.COMPOUND -> Category.COMPOUND
        CategoryEnum.ISOLATION -> Category.ISOLATION
        CategoryEnum.UNKNOWN -> null
    }
}

private fun ForceTypeEnum.toState(): ForceType? {
    return when (this) {
        ForceTypeEnum.PULL -> ForceType.PULL
        ForceTypeEnum.PUSH -> ForceType.PUSH
        ForceTypeEnum.HINGE -> ForceType.HINGE
        ForceTypeEnum.UNKNOWN -> null
    }
}