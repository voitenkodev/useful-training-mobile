package models

data class Exercise(
    val name: String,
    val iterations: List<Iteration>,
) {

    data class Iteration(
        val weight: Double,
        val count: Int
    )

    companion object {
        val MOCK = Exercise(
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