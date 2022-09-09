package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object DesignComponent {

    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}

internal val LocalAppColors = staticCompositionLocalOf<AppColors> { error("No colors provided") }

internal val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("No font provided") }