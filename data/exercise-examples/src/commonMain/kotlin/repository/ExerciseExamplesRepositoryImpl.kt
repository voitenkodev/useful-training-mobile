package repository

import DataBaseSource
import ExerciseExamplesRepository

internal class ExerciseExamplesRepositoryImpl(
    private val local: DataBaseSource
) : ExerciseExamplesRepository {

    override fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override fun getExerciseNameOptions() = local
        .getExerciseNames()

    override fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}