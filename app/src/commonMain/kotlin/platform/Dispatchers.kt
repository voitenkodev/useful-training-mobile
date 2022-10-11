package platform

import kotlin.coroutines.CoroutineContext

expect val defaultDispatcher: CoroutineContext

expect val ioDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext