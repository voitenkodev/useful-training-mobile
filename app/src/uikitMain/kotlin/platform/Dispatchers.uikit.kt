package platform

import co.touchlab.stately.freeze
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

actual val defaultDispatcher: CoroutineContext = MainDispatcher

actual val ioDispatcher: CoroutineContext = MainDispatcher

actual val uiDispatcher: CoroutineContext = MainDispatcher

@ThreadLocal
private object MainDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            try {
                block.run().freeze()
            } catch (err: Throwable) {
                throw err
            }
        }
    }
}