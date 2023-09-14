package repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import source.network.NetworkSource

class OpenAIRepositoryImpl(
    private val remote: NetworkSource,
) : OpenAIRepository {

    override fun generateMapOfMuscleCoverage(exerciseName: String): Flow<String> {
        val promt = buildString {
            append("Список групп мышц в процентном соотношении для упражнения \"${exerciseName}\"")
            append("\n")
            append("Выведи только результат, без дополнительной информации")
        }
        return remote.generateViaOpenAI(promt).map { it.toString() }
    }
}