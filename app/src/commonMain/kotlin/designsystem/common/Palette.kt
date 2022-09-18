package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LightPalette() = DarkPalette()

@Composable
fun DarkPalette() = AppColors(
    primary = color_black,
    secondary = color_black_50,

    accent_primary = color_blue,
    accent_secondary = color_yellow,

    content = color_white,
    caption = color_gray,
)

data class AppColors(
    val primary: Color,
    val secondary: Color,

    val accent_primary: Color,
    val accent_secondary: Color,

    val content: Color,
    val caption: Color,
)

val color_white = Color(0xffffffff)
val color_gray = Color(0xff7f8899)

val color_black = Color(0xff000000)
val color_black_50 = Color(0xff18181c)

val color_blue = Color(0xff335bff)
val color_yellow = Color(0xffffb005)