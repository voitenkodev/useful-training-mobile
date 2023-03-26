package design

import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import design.atomic.appDp
import design.atomic.appShape
import design.atomic.appTypography
import design.atomic.darkPalette

@Composable
internal fun DesignTheme(
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
            modifier = Modifier.background(Design.colors.primary).then(modifier),
            color = Design.colors.primary,
            content = content
        )
    }
)
