package data.source.database

import UsefulTrainingDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class LocalDataSource(private val database: UsefulTrainingDatabase) {
    fun setExerciseNames(names: List<String>): Flow<Unit> {
        val request = database.transactionWithResult {
            names.forEach {
                database.user_exercise_namesQueries.insert(it)
            }
        }
        return flowOf(request)
    }

    suspend fun getExerciseNames(): Flow<List<String>> {
        return flow {
            emit(database.user_exercise_namesQueries.selectAll().executeAsList())
        }
    }

    suspend fun removeExerciseName(names: List<String>): Flow<Unit> {
        TODO("Not yet implemented")
    }
}