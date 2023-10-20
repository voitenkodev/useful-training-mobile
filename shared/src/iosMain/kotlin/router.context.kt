import com.arkivanov.essenty.backhandler.BackDispatcher
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.destroy
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import io.github.xxfast.decompose.router.RouterContext

/**
 * Docs
 *
 * https://github.com/xxfast/Decompose-Router/tree/main
 *
 * Issue for defaultRouterContextBuilder solution
 *
 * https://github.com/xxfast/Decompose-Router/pull/65/files
**/

public fun defaultRouterContext(): RouterContext = defaultRouterContextBuilder()
public val Lifecycle.registry: LifecycleRegistry get() = this as LifecycleRegistry
public fun Lifecycle.destroy(): Unit = registry.destroy()
public fun Lifecycle.resume(): Unit = registry.resume()
public fun Lifecycle.stop(): Unit = registry.stop()
private fun defaultRouterContextBuilder(): RouterContext {
    val backDispatcher = BackDispatcher()
    val lifecycle = LifecycleRegistry()
    return RouterContext(lifecycle = lifecycle, backHandler = backDispatcher)
}