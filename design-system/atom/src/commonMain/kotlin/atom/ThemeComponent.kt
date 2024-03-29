package atom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

public object Design {
    public val colors: Color
        @Composable get() = LocalColor.current
    public val typography: Typography
        @Composable get() = LocalTypography.current
    public val dp: Dp
        @Composable get() = LocalDp.current
    public val shape: Shape
        @Composable get() = LocalShape.current

    // Hack (probably find another way to use colors from ViewModel)
    public val palette: Color = Color()
}

internal val LocalColor = staticCompositionLocalOf<Color> { error("No colors provided") }

internal val LocalTypography = staticCompositionLocalOf<Typography> { error("No font provided") }

internal val LocalDp = staticCompositionLocalOf<Dp> { error("No dp provided") }

internal val LocalShape = staticCompositionLocalOf<Shape> { error("No shape provided") }