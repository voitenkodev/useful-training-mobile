import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import navigation.GlobalGraph
import navigation.NavigatorState

@Composable
fun Main(modifier: Modifier = Modifier) {
    DesignTheme(modifier = modifier) {
        StoreProvider(store) {
            NavigatorState {
                GlobalGraph(direction = it)
            }
        }
    }
}