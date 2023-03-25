import data.source.datastore.createDataStore
import data.source.datastore.dataStoreFileName
import data.source.network.Client
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal actual val platformModule = module {

    factory {
        val engine = HttpClient(OkHttp)
        Client(get(), engine).address()
    }

    single {
        createDataStore(
            coroutineScope = CoroutineScope(Dispatchers.Default),
            producePath = { androidContext().filesDir.resolve(dataStoreFileName).absolutePath }
        )
    }
}