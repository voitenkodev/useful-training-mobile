package design

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import design.atomic.AppColors
import design.atomic.AppDp
import design.atomic.AppShape
import design.atomic.AppTypography

object Design {

    internal val colors: AppColors
        @Composable get() = LocalAppColors.current

    internal val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    internal val dp: AppDp
        @Composable get() = LocalAppDp.current

    internal val shape: AppShape
        @Composable get() = LocalAppShape.current
}

internal val LocalAppColors = staticCompositionLocalOf<AppColors> { error("No colors provided") }

internal val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("No font provided") }

internal val LocalAppDp = staticCompositionLocalOf<AppDp> { error("No dp provided") }

internal val LocalAppShape = staticCompositionLocalOf<AppShape> { error("No shape provided") }