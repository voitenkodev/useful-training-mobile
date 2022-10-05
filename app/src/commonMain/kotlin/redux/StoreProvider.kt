package redux

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import co.touchlab.kermit.Logger
import org.reduxkotlin.Dispatcher
import org.reduxkotlin.Middleware
import org.reduxkotlin.Store
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore

val store: Store<GlobalState> = createStore(
    globalReducer,
    GlobalState(),
    applyMiddleware(createMiddleware { action -> Logger.i { "reduxLogger::DISPATCHED => \"${action.group}/${action.action}\"" } })
)

private val LocalStore: ProvidableCompositionLocal<Store<*>> = compositionLocalOf { error("undefined") }

@Composable
fun <T> StoreProvider(store: Store<T>, content: @Composable Store<T>.() -> Unit) {
    CompositionLocalProvider(LocalStore provides store) { store.content() }
}

@Composable
inline fun <reified TState, TSlice> selectState(
    crossinline selector: @DisallowComposableCalls TState.() -> TSlice
): State<TSlice> {
    return rememberStore<TState>().selectState(selector)
}

@Composable
fun rememberDispatcher(): Dispatcher = rememberStore<Any>().dispatch

@Composable
inline fun <TState, TSlice> Store<TState>.selectState(
    crossinline selector: @DisallowComposableCalls TState.() -> TSlice
): State<TSlice> {
    val result = remember { mutableStateOf(state.selector()) }
    DisposableEffect(result) {
        val unsubscribe = subscribe { result.value = state.selector() }
        onDispose(unsubscribe)
    }
    return result
}

@Composable
@Suppress("UNCHECKED_CAST")
fun <TState> rememberStore(): Store<TState> = LocalStore.current as Store<TState>

private fun createMiddleware(logic: (action: Action) -> Unit): Middleware<GlobalState> {
    return {
        { next ->
            { action ->
                if (action is Action) logic(action)
                next(action)
            }
        }
    }
}