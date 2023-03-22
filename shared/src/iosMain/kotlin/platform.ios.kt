import data.source.datastore.createDataStore
import data.source.datastore.dataStoreFileName
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

internal actual object KtorFactory {
    internal actual fun client() = HttpClient(Darwin) {
        engine { configureRequest { setAllowsCellularAccess(true) } }
    }
}

internal actual object DataStoreFactory {

    internal actual val client = createDataStore(
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