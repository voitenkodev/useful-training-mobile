package exercise.mapping

import equipment.mapping.toState
import exercise.Category
import exercise.ExerciseExample
import exercise.ForceType
import exercise.WeightType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import models.CategoryEnum
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

private fun models.ForceTypeEnum.toState(): ForceType? {
    return when (this) {
        models.ForceTypeEnum.PULL -> ForceType.PULL
        models.ForceTypeEnum.PUSH -> ForceType.PUSH
        else -> null
    }
}