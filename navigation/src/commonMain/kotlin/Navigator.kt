import androidx.compose.runtime.Composable
import internal.LocalAppNavigator
import kotlinx.coroutines.flow.StateFlow

object NavigationComponent {

    val navigator: Navigator
        @Composable
        get() = LocalAppNavigator.current

}


interface Navigator {

    val state: StateFlow<NavController>

    fun direct(screen: Screen, popToInclusive: Boolean = false)

    fun back()
}