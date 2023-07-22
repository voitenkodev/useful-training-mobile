import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient

expect class NativeContext private constructor()

internal expect fun NativeContext.driver(): HttpClient
internal expect fun NativeContext.database(): UsefulTrainingDatabase
internal expect fun NativeContext.preferences(): DataStore<Preferences>