package models

import kotlinx.serialization.Serializable

@Serializable
public data class ExerciseDateDto(
    val trainingId: String? = null,
    val exercise: ExerciseDto,
    val date: String,
)