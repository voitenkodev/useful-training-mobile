package data.filters

import FiltersRepository
import data.filters.mapping.dtoToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import models.ExerciseExampleFilters
import network.NetworkSource

internal class FiltersRepositoryImpl(
    private val remote: NetworkSource
) : FiltersRepository {

    override fun getExerciseExampleFilters(): Flow<ExerciseExampleFilters> {
        return flow {
            val result = remote.getExerciseExampleFilters().dtoToDomain()
            emit(result)
        }
    }
}