package models

import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    val id: String,
    val name: String,
    val iterations: List<Pair<Double, Int>>,
) {

    companion object {
        fun empty(id: String) = Exercise(
            id = id,
            name = "",
            listOf(
                0.0 to 0,
                0.0 to 0,
                0.0 to 0,
                0.0 to 0,
                0.0 to 0,
            )
        )

        val MOCK = Exercise(
            id = "0",
            "Bench press",
            listOf(
                0.0 to 0,
                0.0 to 0,
                0.0 to 0,
                0.0 to 0,
                0.0 to 0,
            )
        )
    }
}