import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@Composable
fun rememberComposeCoroutineContext(): ComposeCoroutineContext {
    return remember { ComposeCoroutineContext() }
}

open class ComposeCoroutineContext : RememberObserver {

    private val scope = CoroutineScope(Dispatchers.Default)
    private var job: Job? = null
    private val tasks: MutableList<suspend CoroutineScope.() -> Unit> = mutableListOf()

    fun call(task: suspend CoroutineScope.() -> Unit) {
        tasks.add(task)
        if (job?.isActive == true) {
            Logger.i { "job?.isActive == true launch" }
            scope.launch(block = task)
        } else {
            Logger.i { "job?.isActive == false launch" }
            job = scope.launch { scope.launch(block = task) }
        }
    }

    override fun onRemembered() {
        Logger.i { "ComposeCoroutineContext onRemembered" }
        job?.cancel("Old job was still running!")
        job = scope.launch {
            tasks.forEach { task ->
                scope.launch(block = task)
            }
        }
    }

    override fun onForgotten() {
        Logger.i { "ComposeCoroutineContext onForgotten" }
        job?.cancel()
        job = null
    }

    override fun onAbandoned() {
        Logger.i { "ComposeCoroutineContext onAbandoned" }
        job?.cancel()
        job = null
    }
}
