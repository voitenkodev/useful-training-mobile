import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesSource(nativeContext: NativeContext) {

    private val preferences: DataStore<Preferences> = nativeContext.preferences()

    suspend fun setToken(token: String) {
        preferences.edit { it[KEY_TOKEN] = token }
    }

    fun getToken(): Flow<String?> {
        return preferences.data.map { it[KEY_TOKEN] }
    }

    suspend fun removeToken() {
        preferences.edit { it.clear() }
    }

    companion object DataStoreKeys {
        private val KEY_TOKEN = stringPreferencesKey("key_token")
    }
}