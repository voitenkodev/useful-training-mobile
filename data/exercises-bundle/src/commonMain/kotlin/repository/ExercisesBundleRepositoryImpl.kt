package repository

import DataBaseSource
import ExercisesBundleRepository

internal class ExercisesBundleRepositoryImpl(
    private val local: DataBaseSource
) : ExercisesBundleRepository {

    override fun setExerciseNameOptions(names: List<String>) = local
        .setExerciseNames(names)

    override fun getExerciseNameOptions() = local
        .getExerciseNames()

    override fun removeExerciseNameOption(value: String) = local
        .removeExerciseName(value)
}