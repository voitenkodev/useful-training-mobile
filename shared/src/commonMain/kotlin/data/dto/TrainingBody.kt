package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TrainingBody(
    val id: String? = null,
    val exercises: List<Exercise> = emptyList(),
    val duration: String?,
    val date: String?,

    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
) {

    @Serializable
    data class Exercise(
        val id: String? = null,
        val name: String?,
        val iterations: List<Iteration> = emptyList(),

        val tonnage: Double?,
        val countOfLifting: Int?,
        val intensity: Double?,
    ) {
        @Serializable
        data class Iteration(
            val id: String? = null,
            val weight: Double?,
            val repeat: Int?
        )
    }
}