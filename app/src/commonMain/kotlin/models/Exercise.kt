package models

import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    val id: String,
    val name: String,
    val iterations: List<Iteration>,
) {

    @Serializable
    data class Iteration(
        val weight: Double,
        val count: Int
    )

    companion object {
        fun empty(id: String) = Exercise(
            id = id,
            name = "",
            listOf(
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0)
            )
        )

        val MOCK = Exercise(
            id = "0",
            "Bench press",
            listOf(
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0),
                Iteration(0.0, 0)
            )
        )
    }
}