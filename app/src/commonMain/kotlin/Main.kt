import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Main(
    modifier: Modifier = Modifier,
    finalize: () -> Unit
) {
    DesignTheme(modifier = modifier) {

        StoreProvider(store = store) {

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
