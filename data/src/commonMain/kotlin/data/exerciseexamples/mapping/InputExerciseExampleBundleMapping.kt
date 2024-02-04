package data.exerciseexamples.mapping

import models.InputExerciseExampleBundle
import network.models.ExerciseExampleBundleDto

internal fun List<InputExerciseExampleBundle>.domainToDto(): List<ExerciseExampleBundleDto> {
    return map {
        it.domainToDto()
    }
}

internal fun InputExerciseExampleBundle.domainToDto(): ExerciseExampleBundleDto {
    return ExerciseExampleBundleDto(
        percentage = percentage,
        muscleId = muscleId
    )
}