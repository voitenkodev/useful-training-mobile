package models

import kotlinx.serialization.Serializable

@Serializable
data class Training(
    val id: String,
    val exercises: List<Exercise>,
    val duration: String,

    val tonnage: Double,
    val countOfLifting: Int,
    val intensity: Double,
) {
    companion object {
        fun empty(id: String) = Training(
            id = id,
            exercises = emptyList(),
            duration = "",
            tonnage = 0.0,
            countOfLifting = 0,
            intensity = 0.0,
        )
    }
}