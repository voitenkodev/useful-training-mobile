import androidx.compose.runtime.Composable
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
}

@Composable
internal actual fun PlatformBackHandler(action: () -> Unit) {}