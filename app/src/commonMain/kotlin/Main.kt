import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import content.AuthContent
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import state.AuthState

@Composable
fun Main(
    modifier: Modifier = Modifier
) {
    DesignTheme {
        Surface(
            modifier = modifier,
            color = DesignComponent.colors.primary
        ) {
            AuthContent(
                state = AuthState.EMPTY,
                update = {},
                registration = {},
                login = {}
            )
        }
    }
}