import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

public class ClientBackend(
    nativeContext: NativeContext,
    private val token: suspend () -> String
) {

    private val client: HttpClient = nativeContext.driver()

    public fun setup(): HttpClient = client.config {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }

        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(token.invoke(), "")
                }
            }
        }

        defaultRequest {
            host = "192.168.0.107:3010"
//            host = "192.168.31.183:3010"
//            host = "192.168.88.201:3010"
            url { protocol = URLProtocol.HTTP }
//            url { protocol = URLProtocol.HTTPS }
            contentType(ContentType.Application.Json)
        }
    }
}