package source.network

import NativeContext
import driver
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

internal class ClientOpenAI(
    nativeContext: NativeContext
) {

    private val client: HttpClient = nativeContext.driver()

    fun setup() = client.config {
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
                    val token = "" // TODO GET TOKEN FROM CI/CD
                    BearerTokens(token, "")
                }
            }
        }

        defaultRequest {
            host = "api.openai.com"
            url { protocol = URLProtocol.HTTPS }
            contentType(ContentType.Application.Json)
        }
    }
}