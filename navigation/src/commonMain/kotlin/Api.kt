import androidx.compose.runtime.Composable
import internal.LocalNavigator

@Composable
public fun findNavigator(): NavigatorCore = LocalNavigator.current
public interface NavigatorCore {
    public fun navigate(screen: String, popToInclusive: Boolean = false)
    public fun back()
}

public interface GraphBuilder {
    public fun screen(
        key: String,
        animation: Animation? = null,
        content: @Composable (ScreenScope) -> Unit
    )
}

public interface ScreenScope {
    public fun <T : Any> getOrCreate(key: String, factory: () -> T, clear: (T) -> Unit): T
}