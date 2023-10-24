package exerciseexample.repository

import ExerciseExamplesRepository
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import models.ExerciseExample
import models.Muscle
import exerciseexample.repository.mapping.toDao
import exerciseexample.repository.mapping.toDomain

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
        return local
            .setExerciseExampleWithMuscles(
                exerciseExample = exerciseExample.toDao(),
                muscles = muscles.toDao()
            )
    }

    override fun setMuscleWithExerciseExamples(muscle: Muscle, exerciseExamples: List<ExerciseExample>) {
        return local
            .setMuscleWithExerciseExamples(
                muscle = muscle.toDao(),
                exerciseExamples = exerciseExamples.toDao()
            )
    }
}