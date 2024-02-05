package data.statistics

import StatisticsRepository
import data.statistics.mapping.dtoToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import models.ExerciseExampleAchievements
import network.NetworkSource

internal class StatisticsRepositoryImpl(private val remote: NetworkSource) : StatisticsRepository {

    override fun getExerciseExampleAchievements(exerciseExampleId: String, size: Int): Flow<ExerciseExampleAchievements> {
        return flow {
            val result = remote
                .getExerciseExampleAchievements(exerciseExampleId, size)
                .dtoToDomain()

            if (result != null) emit(result)
        }
    }
}