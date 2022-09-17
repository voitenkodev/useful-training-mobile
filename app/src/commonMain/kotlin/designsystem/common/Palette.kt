package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LightPalette() = AppColors(
    primary100 = color_white_100,
    primary50 = color_white_50,
    primary70 = color_white_70,
    primaryInverse100 = color_black_100,
    primaryInverse50 = color_black_50,

    secondary100 = color_1,
    secondary50 = color_2,
    secondaryInverse100 = color_white_100,
    secondaryInverse50 = color_black_100,

    tertiary100 = color_5,
    tertiary50 = color_4,
    tertiaryInverse = color_white_100
)

@Composable
fun DarkPalette() = LightPalette()

data class AppColors(
    val primary100: Color,
    val primary70: Color,
    val primary50: Color,

    val primaryInverse100: Color,
    val primaryInverse50: Color,

    val secondary100: Color,
    val secondary50: Color,
    val secondaryInverse100: Color,
    val secondaryInverse50: Color,

    val tertiary100: Color,
    val tertiary50: Color,
    val tertiaryInverse: Color,
)

val color_white_100 = Color(0xffffffff)
val color_white_70 = Color(0xfff5f5f5)
val color_white_50 = Color(0xffdae4f5)
val color_black_100 = Color(0xff000000)
val color_black_50 = Color(0xffa8a8a8)

val color_1 = Color(0xff2ec4b6)
val color_2 = Color(0xffcbf3f0)

val color_4 = Color(0xffffe5c3)
val color_5 = Color(0xffffb005)
