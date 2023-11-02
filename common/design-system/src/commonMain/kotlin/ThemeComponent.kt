import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import atom.Color
import atom.Dp
import atom.Shape
import atom.Typography

public object Design {

    public val colors: Color
        @Composable get() = LocalColor.current

    public val typography: Typography
        @Composable get() = LocalTypography.current

    public val dp: Dp
        @Composable get() = LocalDp.current

    public val shape: Shape
        @Composable get() = LocalShape.current
}

internal val LocalColor = staticCompositionLocalOf<Color> { error("No colors provided") }

internal val LocalTypography = staticCompositionLocalOf<Typography> { error("No font provided") }

internal val LocalDp = staticCompositionLocalOf<Dp> { error("No dp provided") }

internal val LocalShape = staticCompositionLocalOf<Shape> { error("No shape provided") }