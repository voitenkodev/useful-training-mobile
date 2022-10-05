import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.common.DesignTheme
import redux.StoreProvider
import redux.store

@Composable
fun Main(
    modifier: Modifier = Modifier
) {
    DesignTheme {
        StoreProvider(store) {
        }
    }
}