import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

internal actual fun NativeContext.driver(): HttpClient {
    return HttpClient(OkHttp)
}