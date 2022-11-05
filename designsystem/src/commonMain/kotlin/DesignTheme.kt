import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import atomic.AppShape
import atomic.AppSize
import atomic.AppTypography
import atomic.DarkPalette
import atomic.LightPalette

@ExperimentalUnitApi
@Composable
fun DesignTheme(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false, // need isSystemInDarkTheme()
    content: @Composable () -> Unit
) = CompositionLocalProvider(

    LocalAppColors provides when (darkTheme) {
        true -> DarkPalette()
        false -> LightPalette()
    },

    LocalAppTypography provides AppTypography(),

    LocalAppSize provides AppSize(),

    LocalAppShape provides AppShape(),

    content = {
        Surface(
            modifier = Modifier.background(Design.colors.primary).then(modifier),
            color = Design.colors.primary,
            content = content
        )
    }
)
