import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import atomic.dp
import atomic.shape
import atomic.typography
import atomic.darkPalette
import atomic.duration
import controls.primaryBackground

@Composable
fun DesignTheme(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) = CompositionLocalProvider(

    LocalColor provides when (darkTheme) {
        true -> darkPalette()
        false -> darkPalette()
    },

    LocalTypography provides typography(),

    LocalDp provides dp(),

    LocalShape provides shape(),

    LocalDuration provides duration(),

    content = {
        Surface(
            modifier = Modifier.primaryBackground().then(modifier),
            color = Design.colors.primary,
            content = content
        )
    }
)
