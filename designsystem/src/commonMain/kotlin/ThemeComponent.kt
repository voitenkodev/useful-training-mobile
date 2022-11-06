import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import atomic.AppColors
import atomic.AppShape
import atomic.AppDp
import atomic.AppTypography

object Design {

    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current

    val dp: AppDp
        @Composable
        get() = LocalAppDp.current

    val shape: AppShape
        @Composable
        get() = LocalAppShape.current
}

internal val LocalAppColors = staticCompositionLocalOf<AppColors> { error("No colors provided") }

internal val LocalAppTypography = staticCompositionLocalOf<AppTypography> { error("No font provided") }

internal val LocalAppDp = staticCompositionLocalOf<AppDp> { error("No dp provided") }

internal val LocalAppShape = staticCompositionLocalOf<AppShape> { error("No shape provided") }