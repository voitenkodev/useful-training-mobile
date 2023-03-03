//package utils
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.CompositionLocalProvider
//import androidx.compose.runtime.DisallowComposableCalls
//import androidx.compose.runtime.DisposableEffect
//import androidx.compose.runtime.ProvidableCompositionLocal
//import androidx.compose.runtime.State
//import androidx.compose.runtime.compositionLocalOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import co.touchlab.kermit.Logger
//import org.reduxkotlin.Dispatcher
//import org.reduxkotlin.Middleware
//import org.reduxkotlin.Reducer
//import org.reduxkotlin.Store
//import org.reduxkotlin.applyMiddleware
//import org.reduxkotlin.createStore
//
///**
// * val dispatcher = rememberDispatcher()
// * val state by selectState<GlobalState, ReviewState> { this.reviewState }
// **/
//
//internal typealias Reducer<State> = (state: State, action: Any) -> State
//
//internal typealias ReducerForActionType<TState, GState, TAction> = (state: TState, globalState: GState, action: TAction) -> TState
//
//private val LocalStore: ProvidableCompositionLocal<Store<*>> = compositionLocalOf { error("undefined") }
//
//private var store: Store<*>? = null
//
//private fun <State, Reduce : Reducer<State>> provideStore(state: State, reducer: Reduce) {
//    if (store == null)
//        store = createStore(
//            reducer,
//            state,
//            applyMiddleware(createMiddleware<Any, State> { action -> Logger.i { "reduxLogger::DISPATCHED => \"$action" } }
//            )
//        )
//}
//
//@Composable
//internal fun <State, Reduce : Reducer<State>> ReduxStoreProvider(
//    state: State, reducer: Reduce,
//    content: @Composable () -> Unit
//) {
//    provideStore(state, reducer)
//    val store = store ?: error("Store is not provided, please use `provideStore` to provide store")
//    CompositionLocalProvider(LocalStore provides store, content = content)
//}
//
//
//@Composable
//internal fun <T> StoreProvider(store: Store<T>, content: @Composable Store<T>.() -> Unit) {
//    CompositionLocalProvider(LocalStore provides store) { store.content() }
//}
//
//@Composable
//internal inline fun <reified TState, TSlice> selectState(crossinline selector: @DisallowComposableCalls TState.() -> TSlice): State<TSlice> {
//    return rememberStore<TState>().selectState(selector)
//}
//
//@Composable
//internal fun rememberDispatcher(): Dispatcher = rememberStore<Any>().dispatch
//
//@Composable
//inline fun <TState, TSlice> Store<TState>.selectState(crossinline selector: @DisallowComposableCalls TState.() -> TSlice): State<TSlice> {
//    val result = remember { mutableStateOf(state.selector()) }
//    DisposableEffect(result) {
//        val unsubscribe = subscribe { result.value = state.selector() }
//        onDispose(unsubscribe)
//    }
//    return result
//}
//
//@Composable
//@Suppress("UNCHECKED_CAST")
//internal fun <TState> rememberStore(): Store<TState> = LocalStore.current as Store<TState>
//
//internal inline fun <reified Action, State> createMiddleware(crossinline logic: (action: Action) -> Unit): Middleware<State> {
//    return {
//        { next ->
//            { action ->
//                if (action is Action) logic(action)
//                next(action)
//            }
//        }
//    }
//}