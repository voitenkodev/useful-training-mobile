import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.DesignTheme
import graph.RootGraph
import imagecore.ImageFactory

@Composable
internal fun Main(modifier: Modifier = Modifier) {
    ImageFactory()

    DesignTheme(modifier = modifier) {
        RootGraph()
    }
}
