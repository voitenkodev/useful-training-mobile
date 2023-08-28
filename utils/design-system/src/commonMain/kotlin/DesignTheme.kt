import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import atomic.appDp
import atomic.appShape
import atomic.appTypography
import atomic.darkPalette
import controls.primaryBackground

@Composable
fun DesignTheme(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) = CompositionLocalProvider(

    LocalAppColors provides when (darkTheme) {
        true -> darkPalette()
        false -> darkPalette()
    },

    LocalAppTypography provides appTypography(),

    LocalAppDp provides appDp(),

    LocalAppShape provides appShape(),

    content = {
        Surface(
            modifier = Modifier.primaryBackground().then(modifier),
            color = Design.colors.primary,
            content = content
        )
    }
)
