import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.driver.native.wrapConnection
import co.touchlab.sqliter.DatabaseConfiguration
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask
import source.database.DB_FILE_NAME
import source.datastore.createDataStore
import source.datastore.dataStoreFileName

internal actual fun NativeContext.driver(): HttpClient {
    return HttpClient(Darwin) { engine { configureRequest { setAllowsCellularAccess(true) } } }
}

internal actual fun NativeContext.database(): UsefulTrainingDatabase {
    val dbConfig = DatabaseConfiguration(
        name = DB_FILE_NAME,
        version = UsefulTrainingDatabase.Schema.version,
        extendedConfig = DatabaseConfiguration.Extended(foreignKeyConstraints = true),
        create = { connection ->
            wrapConnection(connection) { UsefulTrainingDatabase.Schema.create(it) }
        }
    )
    return UsefulTrainingDatabase.invoke(NativeSqliteDriver(dbConfig))
}

internal actual fun NativeContext.preferences(): DataStore<Preferences> {
    return createDataStore(
        coroutineScope = CoroutineScope(Dispatchers.Default),
        producePath = {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/$dataStoreFileName"
        }
    )
}