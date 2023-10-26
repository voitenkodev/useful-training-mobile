package exerciseexample.repository

import ExerciseExamplesRepository
import exercise_example_muscle.ExerciseExamplesSource
import exerciseexample.repository.mapping.toDao
import exerciseexample.repository.mapping.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import models.ExerciseExample
import models.Muscle

internal class ExerciseExamplesRepositoryImpl(
    private val local: ExerciseExamplesSource
) : ExerciseExamplesRepository {

    override fun getExerciseExamples(): Flow<List<ExerciseExample>> {
        return local.getExerciseExamples()
            .map {
                it.toDomain()
            }
    }

    override fun getMuscles(): Flow<List<Muscle>> {
        return local.getMuscles()
            .map {
                it.toDomain()
            }
    }

    override fun getExerciseExampleWithMusclesById(exerciseExampleId: String): Flow<Pair<ExerciseExample, List<Muscle>>> {
        return local
            .getExerciseExampleWithMusclesById(exerciseExampleId)
            .mapNotNull {
                val value = it.firstOrNull() ?: return@mapNotNull null
                val exerciseExample = value.first.toDomain() ?: return@mapNotNull null
                val muscles = value.second.toDomain()
                exerciseExample to muscles
            }
    }

    override fun getMuscleWithExerciseExamplesById(muscleId: String): Flow<Pair<Muscle, List<ExerciseExample>>> {
        return local
            .getMuscleWithExerciseExamplesById(muscleId)
            .mapNotNull {
                val value = it.firstOrNull() ?: return@mapNotNull null
                val muscle = value.first.toDomain() ?: return@mapNotNull null
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

    override fun deleteExerciseExample(exerciseExampleId: String) {
        local.deleteExerciseExample(
            exerciseExampleId = exerciseExampleId
        )
    }

    override fun deleteMuscle(muscleId: String) {
        local.deleteMuscle(
            muscleId = muscleId
        )
    }
}