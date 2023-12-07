package data.traininigs.repository

import NetworkSource
import TrainingsRepository
import data.traininigs.mapping.daoToDomain
import data.traininigs.mapping.domainToDto
import data.traininigs.mapping.dtoToDao
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import models.Training
import traininig_exercise_iteration.TrainingsSource

internal class TrainingsRepositoryImpl(
    private val remote: NetworkSource,
    private val localTrainings: TrainingsSource,
    private val localExerciseExamples: ExerciseExamplesSource
) : TrainingsRepository {

    override fun observeTrainings(startDate: String, endDate: String): Flow<List<Training>> {
        return localTrainings
            .getTrainings()
            .map { it.daoToDomain() }
    }

    override fun syncTrainings(startDate: String, endDate: String): Flow<Unit> {
        return flow {
            val result = remote.getTrainings(startDate, endDate)
            localTrainings.setTrainings(result.dtoToDao())
            emit(Unit)
        }
    }

    override fun observeTraining(trainingId: String): Flow<Training?> {
        return localTrainings
            .getTraining(trainingId)
            .map { it?.daoToDomain() }
    }

    override fun setTraining(training: Training): Flow<String?> {
        return flow {
            val id = remote
                .setTraining(body = training.domainToDto())
                .dtoToDao()
                ?.let { dao ->
                    val id = localTrainings.setTraining(dao)
                    val examples = dao.exercises.mapNotNull { it.exerciseExample }
                    localExerciseExamples.setExerciseExamples(examples)
                    id
                }
            emit(id)
        }
    }

    override fun clearCache() {
        localTrainings.clearTables()
    }

    override fun deleteTraining(trainingId: String): Flow<Unit> =
        flow {
//            remote.deleteTraining(trainingId)
//            local.deleteTraining(trainingId)
//            emit(Unit)
        }
}