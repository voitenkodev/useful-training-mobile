package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ExerciseDateDTO(
    val trainingId: String? = null,
    val exercise: ExerciseDTO? = null,
    val date: String,
)