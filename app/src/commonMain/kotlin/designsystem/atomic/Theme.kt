package designsystem.atomic

import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi

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
            modifier = Modifier.background(DesignComponent.colors.primary).then(modifier),
            color = DesignComponent.colors.primary,
            content = content
        )
    }
)
