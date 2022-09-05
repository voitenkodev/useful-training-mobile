package ui.designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun LightPalette() = AppColors(
    primary = white,
    primaryInverse = almostBlack,
    secondary = almostWhite,
    secondaryInverse = almostWhite,
    special1 = pink,
    special2 = purple
)

@Composable
fun DarkPalette() = AppColors(
    primary = almostBlack,
    primaryInverse = almostWhite,
    secondary = black,
    secondaryInverse = almostWhite,
    special1 = pink,
    special2 = purple
)

data class AppColors(
    val primary: Color,
    val primaryInverse: Color,
    val secondary: Color,
    val secondaryInverse: Color,

    val special1: Color,
    val special2: Color
) {
    fun specialBrush(): Brush {
        return Brush.horizontalGradient(listOf(special1, special2))
    }
}

internal val black = Color(0xff000000)
internal val white = Color(0xffffffff)

internal val almostWhite = Color(0xFFF1F1F1)
internal val almostBlack = Color(0xFF121311)

internal val purple = Color(0xffa18cd1)
internal val pink = Color(0xfffbc2eb)

