import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import content.AuthContent
import content.TrainingsContent
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import state.AuthState
import state.MOCK_1
import state.MOCK_2
import state.MOCK_3
import kotlin.math.log

@Composable
fun Main() {
    DesignTheme {
        Surface(color = DesignComponent.colors.primary100) {
//            AuthContent(
//                state = AuthState.EMPTY,
//                update = {},
//                registration = {},
//                login = {}
//            )
            TrainingsContent(
                state = listOf(MOCK_1, MOCK_2, MOCK_3),
                get = {},
            )
        }
    }
}