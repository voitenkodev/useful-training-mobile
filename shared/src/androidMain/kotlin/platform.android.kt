import io.ktor.client.*
import io.ktor.client.engine.okhttp.*

internal actual object KtorFactory {
    internal actual fun client() = HttpClient(OkHttp)
}