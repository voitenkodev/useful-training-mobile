package dto

import kotlinx.serialization.Serializable

@Serializable
data class Training(
    val id: String?,
    val exercises: List<Exercise>?,
    val duration: String?,
    val date: String?,

    val tonnage: Double?,
    val countOfLifting: Int?,
    val intensity: Double?,
) {

    @Serializable
    data class Exercise(
        val id: String?,
        val name: String?,
        val iterations: List<Iteration>?,

        val tonnage: Double?,
        val countOfLifting: Int?,
        val intensity: Double?,
    ) {
        @Serializable
        data class Iteration(
            val weight: Double?,
            val repeat: Int?
        )
    }
}