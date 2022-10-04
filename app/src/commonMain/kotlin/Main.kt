import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme

@Composable
fun Main(
    modifier: Modifier = Modifier
) {
    DesignTheme {
        Surface(
            modifier = modifier,
            color = DesignComponent.colors.primary
        ) {
//            AuthContent(
//                registration = {},
//                login = {}
//            )
        }
    }
}