import io.ktor.client.*
import io.ktor.client.engine.darwin.Darwin

internal actual object KtorFactory {
    internal actual fun client() = HttpClient(Darwin) {
        engine { configureRequest { setAllowsCellularAccess(true) } }
    }
}