import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient

internal expect object KtorFactory {
    internal fun client(): HttpClient
}

internal expect object DataStoreFactory {

    internal val client: DataStore<Preferences>
}

