package utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

internal abstract class ViewModel {

    private val coroutineTags = hashMapOf<String, CoroutineScope>()

    val viewModelScope: CoroutineScope
        get() = coroutineTags[MAIN_JOB_KEY] ?: launchNewScope()

    protected open fun onCleared() {}

    fun clear() {
        coroutineTags.forEach { it.value.cancel() }
        onCleared()
    }

    // Launch view model scope except you provide a new key
    private fun launchNewScope(key: String = MAIN_JOB_KEY): CoroutineScope =
        coroutineTags.getOrPut(key) {
            CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
        }

    companion object {
        private const val MAIN_JOB_KEY = "main.viewmodel.shared.coroutine.job"
    }
}
