import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.reduxkotlin.Dispatcher
import org.reduxkotlin.Middleware
import org.reduxkotlin.Store
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore

/**
 * val dispatcher = rememberDispatcher()
 *
 * val state by selectState<GlobalState, ReviewState> { this.reviewState }
 *
 * */
typealias Reducer<State> = (state: State, action: Any) -> State
typealias ReducerForActionType<TState, GState, TAction> = (state: TState, globalState: GState, action: TAction) -> TState

private val LocalReduxStore: ProvidableCompositionLocal<Store<*>> = compositionLocalOf { error("undefined") }

@Composable
fun <S> ReduxStoreProvider(
    globalState: S,
    globalReducer: Reducer<S>,
    logging: (Any) -> Unit,
    content: @Composable () -> Unit
) {
    val store: Store<S> = createStore(
        globalReducer,
        globalState,
        applyMiddleware(createMiddleware<Any, S> { action ->
            logging.invoke(action)
        })
    )
    CompositionLocalProvider(LocalReduxStore provides store, content = content)
}

@Composable
inline fun <reified TState, TSlice> selectState(
    crossinline selector: @DisallowComposableCalls TState.() -> TSlice
): State<TSlice> = rememberStore<TState>().selectState(selector)

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
fun <TState> rememberStore(): Store<TState> = LocalReduxStore.current as Store<TState>

inline fun <reified Action, State> createMiddleware(crossinline logic: (action: Action) -> Unit): Middleware<State> {
    return {
        { next ->
            { action ->
                if (action is Action) logic(action)
                next(action)
            }
        }
    }
}