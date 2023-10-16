package models

import kotlinx.serialization.Serializable

@Serializable
data class ExerciseDateDto(
    val trainingId: String? = null,
    val exercise: ExerciseDto,
    val date: String,
)