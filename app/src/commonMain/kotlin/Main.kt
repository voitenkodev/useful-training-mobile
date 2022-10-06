import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.atomic.DesignTheme
import navigation.NavigatorState
import presentation.AuthContent
import redux.StoreProvider
import redux.store

@Composable
fun Main(
    modifier: Modifier = Modifier
) {
    DesignTheme {
        StoreProvider(store) {
            NavigatorState {
                AuthContent(
                    registration = {},
                    login = {}
                )
                // Put Graph
            }
        }
    }
}