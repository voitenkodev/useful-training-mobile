package repository

import ExerciseExamplesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import models.ExerciseExample
import models.Muscle
import repository.mapping.toDomain
import exercise_example_muscle.ExerciseExamplesSource

internal class ExerciseExamplesRepositoryImpl(
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

    override fun getExerciseExampleWithMusclesById(exerciseExampleId: Long): Flow<Pair<ExerciseExample, List<Muscle>>?> {
        return local
            .getExerciseExampleWithMusclesById(exerciseExampleId)
            .map {
                val value = it.firstOrNull() ?: return@map null
                val exerciseExample = value.first.toDomain() ?: return@map null
                val muscles = value.second.toDomain()
                exerciseExample to muscles
            }
    }

    override fun getMuscleWithExerciseExamplesById(muscleId: Long): Flow<Pair<Muscle, List<ExerciseExample>>?> {
        return local
            .getMuscleWithExerciseExamplesById(muscleId)
            .map {
                val value = it.firstOrNull() ?: return@map null
                val muscle = value.first.toDomain() ?: return@map null
                val exerciseExamples = value.second.toDomain()
                muscle to exerciseExamples
            }
    }

    override fun setExerciseExampleWithMuscles(exerciseExample: ExerciseExample, muscles: List<Muscle>) {
        TODO("Not yet implemented")
    }

    override fun setMuscleWithExerciseExamples(muscle: Muscle, exerciseExamples: List<ExerciseExample>) {
        TODO("Not yet implemented")
    }
}