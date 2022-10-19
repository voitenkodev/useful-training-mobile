import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.touchlab.kermit.Logger

@Composable
fun Main(
    modifier: Modifier = Modifier,
    finalize: () -> Unit
) {
    DesignTheme(modifier = modifier) {

        StoreProvider(
            globalReducer = globalReducer,
            globalState = GlobalState(),
            logging = { if (it is Action) Logger.i { "reduxLogger::DISPATCHED => \"${it.group}/${it.action}\"" } }
        ) {

            RootController(
                startScreen = Graph.Auth,
                finalize = finalize,
                content = {
                    val navigator = NavigationComponent.navigator
                    navigator.GlobalGraph(this)
                }
            )
        }
    }
}