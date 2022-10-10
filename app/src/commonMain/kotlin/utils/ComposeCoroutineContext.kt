package utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@Composable
fun rememberComposeCoroutineContext(): ComposeCoroutineContext {
    return remember { ComposeCoroutineContext() }
}

class ComposeCoroutineContext : RememberObserver {

    private val scope = CoroutineScope(Dispatchers.Default)
    private var job: Job? = null
    private val tasks: MutableList<suspend CoroutineScope.() -> Unit> = mutableListOf()

    fun call(task: suspend CoroutineScope.() -> Unit) {
        tasks.add(task)
        if (job?.isActive == true) {
            scope.launch(block = task)
        } else {
            job = scope.launch { scope.launch(block = task) }
        }
    }

    override fun onRemembered() {
        job?.cancel("Old job was still running!")
        job = scope.launch {
            tasks.forEach { task ->
                scope.launch(block = task)
            }
        }
    }

    override fun onForgotten() {
        job?.cancel()
        job = null
    }

    override fun onAbandoned() {
        job?.cancel()
        job = null
    }
}
