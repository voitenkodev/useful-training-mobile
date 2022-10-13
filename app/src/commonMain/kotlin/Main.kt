import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.touchlab.kermit.Logger
import navigation.GlobalGraph
import navigation.NavigatorState

@Composable
fun Main(modifier: Modifier = Modifier) {
    DesignTheme(modifier = modifier) {
        StoreProvider(
            globalReducer = globalReducer,
            globalState = GlobalState(),
            logging = { if (it is Action) Logger.i { "reduxLogger::DISPATCHED => \"${it.group}/${it.action}\"" } }
        ) {
            NavigatorState {
                GlobalGraph(direction = it)
            }
        }
    }
}