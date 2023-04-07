package data.source.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineScope
import okio.Path.Companion.toPath

fun createDataStore(
    coroutineScope: CoroutineScope,
    producePath: () -> String
): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
    corruptionHandler = null,
    migrations = emptyList(),
    scope = coroutineScope,
    produceFile = { producePath().toPath() },
)

const val dataStoreFileName = "usefultraining.preferences_pb"

object DataStoreKeys {
    val KEY_TOKEN = stringPreferencesKey("key_token")
}