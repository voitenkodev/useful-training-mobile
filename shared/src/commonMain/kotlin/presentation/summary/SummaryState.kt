package presentation.summary

import presentation.training.Training

internal data class SummaryState(
    val query: String = "",
    val exercises: List<Training.Exercise> = listOf(Training.Exercise()),
    val error: String? = null,
    val loading: Boolean = false,
)