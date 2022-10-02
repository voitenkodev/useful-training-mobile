package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = emptyList(),
    val duration: String? = null,
    val date: String? = null,

    val tonnage: Double? = null,
    val countOfLifting: Int? = null,
    val intensity: Double? = null,
) {

    @Serializable
    data class Exercise(
        val id: String? = null,
        val name: String? = null,
        val iterations: List<Iteration> = emptyList(),

        val tonnage: Double? = null,
        val countOfLifting: Int? = null,
        val intensity: Double? = null,
    ) {
        @Serializable
        data class Iteration(
            val weight: Double? = null,
            val repeat: Int? = null
        )
    }
}