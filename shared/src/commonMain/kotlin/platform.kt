import io.ktor.client.HttpClient

internal expect object KtorFactory {
    internal fun client(): HttpClient
}