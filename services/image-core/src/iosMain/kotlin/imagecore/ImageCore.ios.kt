package imagecore

import coil3.ComponentRegistry
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import platform.Foundation.addValue

internal actual fun imageHttpClient(): HttpClient = HttpClient(Darwin) {
    engine {
        configureRequest {
            defaultHeaders.entries.forEach { header ->
                addValue(header.key, header.value)
            }
        }
    }
}

internal actual fun ComponentRegistry.Builder.addPlatformComponents() {}