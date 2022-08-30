package designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import designsystem.common.AppTypography
import designsystem.common.AppColors

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