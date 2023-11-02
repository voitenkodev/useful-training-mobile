import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.DesignTheme
import graph.RootGraph

@Composable
internal fun Main(modifier: Modifier = Modifier) {

    DesignTheme(modifier = modifier) {
        RootGraph()
    }
}
