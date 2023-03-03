package utils

import androidx.compose.runtime.RememberObserver
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

internal open class ComposeCoroutineContext : RememberObserver {

    private val scope = CoroutineScope(Dispatchers.Default)
    private var job: Job? = null
    private val tasks: MutableList<suspend CoroutineScope.() -> Unit> = mutableListOf()

    fun call(task: suspend CoroutineScope.() -> Unit) {
        tasks.add(task)
        if (job?.isActive == true) {
            Logger.i { "job?.isActive == true launch" }
            scope.launch(block = task)
        } else if (tasks.isNotEmpty()) {
            Logger.i { "job?.isActive == false launch" }
            job = scope.launch {
                launch(block = task).join()
                tasks.remove(task)
            }
        }
    }

    override fun onRemembered() {
        Logger.i { "utils.ComposeCoroutineContext onRemembered" }
        job?.cancelChildren()
        job?.cancel("Old job was still running!")
        job = scope.launch {
            tasks.forEach { task ->
                launch(block = task)
                tasks.remove(task)
            }
        }
    }

    override fun onForgotten() {
        Logger.i { "utils.ComposeCoroutineContext onForgotten" }
        job?.cancelChildren()
        job?.cancel()
        job = null
    }

    override fun onAbandoned() {
        Logger.i { "utils.ComposeCoroutineContext onAbandoned" }
        job?.cancel()
        job = null
    }
}
