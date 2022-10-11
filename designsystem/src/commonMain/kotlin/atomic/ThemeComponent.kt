package atomic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object DesignComponent {

    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current

    val size: AppSize
        @Composable
        get() = LocalAppSize.current

    val shape: AppShape
        @Composable
        get() = LocalAppShape.current
}

internal val LocalAppColors = staticCompositionLocalOf<AppColors> { error("No colors provided") }

internal val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("No font provided") }

internal val LocalAppSize = staticCompositionLocalOf<AppSize> { error("No size provided") }

internal val LocalAppShape = staticCompositionLocalOf<AppShape> { error("No shape provided") }