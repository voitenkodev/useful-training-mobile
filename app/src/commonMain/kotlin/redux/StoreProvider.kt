package redux

import androidx.compose.runtime.*
import co.touchlab.kermit.Logger
import org.reduxkotlin.*

val store = createStore(
    globalReducer,
    GlobalState(),
    applyMiddleware(createMiddleware { action -> Logger.i { "reduxLogger::DISPATCHED => \"${action.group}/${action.action}\"" } })
)

private val LocalStore: ProvidableCompositionLocal<Store<*>> = compositionLocalOf { error("undefined") }

@Composable
@Suppress("FunctionName")
fun <T : Any> StoreProvider(store: Store<T>, content: @Composable Store<T>.() -> Unit) {
    CompositionLocalProvider(LocalStore provides store) {
        store.content()
    }
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
    return { store ->
        { next ->
            { action ->
                if (action is Action) logic(action)
                next(action)
            }
        }
    }
}