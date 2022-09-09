package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.ExperimentalUnitApi

@ExperimentalUnitApi
@Composable
fun DesignTheme(
    darkTheme: Boolean = false, // need isSystemInDarkTheme()
    content: @Composable () -> Unit
) = CompositionLocalProvider(
    LocalAppColors provides when (darkTheme) {
        true -> DarkPalette()
        false -> LightPalette()
    },
    LocalAppTypography provides AppTypography(),
    content = content
)
