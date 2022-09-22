import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import content.AuthContent
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import state.AuthState

@Composable
fun Main() {
    DesignTheme {
        Surface(color = DesignComponent.colors.primary) {
            AuthContent(
                state = AuthState.EMPTY,
                update = {},
                registration = {},
                login = {}
            )
        }
    }
}