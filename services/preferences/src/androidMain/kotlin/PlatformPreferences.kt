import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

internal actual fun NativeContext.preferences(): DataStore<Preferences> {
    return createDataStore(
        coroutineScope = CoroutineScope(Dispatchers.Default),
        producePath = { this.context.filesDir.resolve(dataStoreFileName).absolutePath }
    )
}