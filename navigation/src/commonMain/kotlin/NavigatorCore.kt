import androidx.compose.runtime.Composable
import internal.LocalNavigator
import internal.NavigationSession
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
public fun findNavigator(): NavigatorCore = LocalNavigator.current

public interface NavigatorCore {
    public val session: MutableStateFlow<NavigationSession>
    public fun navigate(screen: String, popToInclusive: Boolean = false)
    public fun back()
}

public interface GraphBuilder {
    public fun screen(screen: String, content: @Composable () -> Unit)
}