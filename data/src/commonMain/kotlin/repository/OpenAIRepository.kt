package repository

import kotlinx.coroutines.flow.Flow

interface OpenAIRepository {

    fun generateMapOfMuscleCoverage(exerciseName: String): Flow<String>

}