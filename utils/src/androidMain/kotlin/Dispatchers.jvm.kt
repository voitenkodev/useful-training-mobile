import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val defaultDispatcher: CoroutineContext = Dispatchers.Default

actual val ioDispatcher: CoroutineContext = Dispatchers.IO

actual val uiDispatcher: CoroutineContext = Dispatchers.Main