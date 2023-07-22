package source.database

import NativeContext
import UsefulTrainingDatabase
import database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class DataBaseSource(nativeContext: NativeContext) {

    private val database: UsefulTrainingDatabase = nativeContext.database()
    private val queries by lazy { database.user_exercise_namesQueries }

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

    suspend fun removeExerciseName(value: String): Flow<String> {
        return flow {
            emit(queries.delete(value_ = value))
        }.map { value }
    }
}