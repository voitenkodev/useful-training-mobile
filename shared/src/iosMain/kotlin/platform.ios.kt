import io.ktor.client.*
import io.ktor.client.engine.ios.*

internal actual object KtorFactory {
    internal actual fun client() = HttpClient(Ios) {
        engine { configureRequest { setAllowsCellularAccess(true) } }
    }
}