import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.source.datastore.createDataStore
import data.source.datastore.dataStoreFileName
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

internal actual object KtorFactory {
    internal actual fun client() = HttpClient(OkHttp)
}

lateinit var platformAppContext: Context

internal actual object DataStoreFactory {
    internal actual val client = createDataStore(
        coroutineScope = CoroutineScope(Dispatchers.Default),
        producePath = { platformAppContext.filesDir.resolve(dataStoreFileName).absolutePath }
    )
    internal actual fun client(scope: CoroutineScope): DataStore<Preferences> = createDataStore(
        coroutineScope = scope,
        producePath = { platformAppContext.filesDir.resolve(dataStoreFileName).absolutePath }
    )
}