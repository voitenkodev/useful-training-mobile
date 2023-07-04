import androidx.compose.runtime.Composable
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.driver.native.wrapConnection
import co.touchlab.sqliter.DatabaseConfiguration
import data.source.database.DB_FILE_NAME
import data.source.datastore.createDataStore
import data.source.datastore.dataStoreFileName
import data.source.network.Client
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask


internal actual val platformModule = module {

    single {
        val engine = HttpClient(Darwin) { engine { configureRequest { setAllowsCellularAccess(true) } } }
        Client(get(), engine).address()
    }

    single {
        createDataStore(
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
    single {
        val dbConfig = DatabaseConfiguration(
            name = DB_FILE_NAME,
            version = UsefulTrainingDatabase.Schema.version,
            extendedConfig = DatabaseConfiguration.Extended(foreignKeyConstraints = true),
            create = { connection ->
                wrapConnection(connection) { UsefulTrainingDatabase.Schema.create(it) }
            },
        )
        NativeSqliteDriver(dbConfig)
    }
}

@Composable
internal actual fun PlatformBackHandler(action: () -> Unit) {
}