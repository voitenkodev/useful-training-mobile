import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

public class PreferencesSource(nativeContext: NativeContext) {

    private val preferences: DataStore<Preferences> = nativeContext.preferences()

    public suspend fun setToken(token: String) {
        preferences.edit { it[KEY_TOKEN] = token }
    }

    public fun getToken(): Flow<String?> {
        return preferences.data.map { it[KEY_TOKEN] }
    }

    public suspend fun removeToken() {
        preferences.edit { it.clear() }
    }

    private companion object DataStoreKeys {
        private val KEY_TOKEN = stringPreferencesKey("key_token")
    }
}