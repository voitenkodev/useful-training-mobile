import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

internal expect fun NativeContext.preferences(): DataStore<Preferences>