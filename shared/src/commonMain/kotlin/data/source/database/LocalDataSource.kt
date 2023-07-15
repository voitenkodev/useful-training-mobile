package data.source.database

import UsefulTrainingDatabase
import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class LocalDataSource(
    database: UsefulTrainingDatabase
) {

    private val queries by lazy {
        database.user_exercise_namesQueries
    }

    fun setExerciseNames(names: List<String>): Flow<Unit> {
        val request = queries.transactionWithResult {
            names.forEach {
                queries.insert(it)
            }
        }
        return flowOf(request)
    }

    suspend fun getExerciseNames(): Flow<List<String>> {
        return flow {
            emit(queries.selectAll().executeAsList())
        }
    }

    suspend fun removeExerciseName(names: List<String>): Flow<Unit> {
        TODO("Not yet implemented")
    }
}