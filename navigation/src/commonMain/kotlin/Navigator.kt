import androidx.compose.runtime.Composable
import internal.LocalAppNavigator
import kotlinx.coroutines.flow.StateFlow

public object NavigationComponent {

    public val navigator: Navigator
        @Composable
        get() = LocalAppNavigator.current
}

public interface Navigator {

    public val state: StateFlow<NavController>

    public fun direct(screen: Screen, popToInclusive: Boolean = false)

    public fun back()
}