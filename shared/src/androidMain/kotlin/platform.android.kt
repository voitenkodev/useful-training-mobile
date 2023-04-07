import android.app.Application
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import data.source.datastore.createDataStore
import data.source.datastore.dataStoreFileName
import data.source.network.Client
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal actual val platformModule = module {

    factory {
        val engine = HttpClient(OkHttp)
        Client(get(), engine).address()
    }

    single {
        createDataStore(
            coroutineScope = CoroutineScope(Dispatchers.Default),
            producePath = { get<Application>().filesDir.resolve(dataStoreFileName).absolutePath }
        )
    }
}

@Composable
internal actual fun PlatformBackHandler(action: () -> Unit) {

    val currentOnBack by rememberUpdatedState(action)

    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBack()
            }
        }
    }

    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner"
    }.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner, backDispatcher) {
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        onDispose { backCallback.remove() }
    }
}