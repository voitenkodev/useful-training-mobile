package data.source.database

import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal interface LocalProtocol {

    suspend fun setExerciseNames(list: List<String>): Flow<Unit>

}

internal class LocalSource(private val client: HttpClient) : LocalProtocol {
    override suspend fun setExerciseNames(list: List<String>): Flow<Unit> {

        return flowOf(Unit)
    }
}