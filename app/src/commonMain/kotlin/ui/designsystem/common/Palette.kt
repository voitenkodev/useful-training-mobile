package ui.designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LightPalette() = AppColors(
    primary = white,
    primaryInverse = almostBlack,
    secondary = almostWhite,
    secondaryInverse = almostWhite,
)

@Composable
fun DarkPalette() = AppColors(
    primary = almostBlack,
    primaryInverse = almostWhite,
    secondary = black,
    secondaryInverse = almostWhite,
)

data class AppColors(
    val primary: Color,
    val primaryInverse: Color,
    val secondary: Color,
    val secondaryInverse: Color,
)

internal val black = Color(0xff000000)
internal val white = Color(0xffffffff)

internal val almostWhite = Color(0xFFF1F1F1)
internal val almostBlack = Color(0xFF121311)