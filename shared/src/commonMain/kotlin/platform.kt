import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope

internal expect object KtorFactory {
    internal fun client(): HttpClient
}

internal expect object DataStoreFactory {

    internal val client: DataStore<Preferences>
    internal fun client(scope: CoroutineScope): DataStore<Preferences>
}

