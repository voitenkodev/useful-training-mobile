package data.exerciseexamples.mapping

import models.InputExerciseExample
import network.models.ExerciseExampleDto
import network.models.ExerciseExampleEquipmentRefDto

internal fun InputExerciseExample.domainToDto(): ExerciseExampleDto {
    return ExerciseExampleDto(
        name = name,
        description = description,
        imageUrl = imageUrl,
        equipmentRefs = equipmentIds.map { ExerciseExampleEquipmentRefDto(equipmentId = it) },
        category = category.toString(),
        weightType = weightType.toString(),
        experience = experience.toString(),
        forceType = forceType.toString(),
        exerciseExampleBundles = exerciseExampleBundles.domainToDto(),
        tutorials = listOfNotNull(exerciseExampleTutorial?.domainToDto())
    )
}