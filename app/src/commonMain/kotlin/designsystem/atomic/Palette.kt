package designsystem.atomic

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

    unique = AppColors.Unique(
        color1 = Color(0xff228D57),
        color2 = Color(0xffD0DBE5), // change
        color3 = Color(0xff5622E5), // change
        color4 = Color(0xffD5BD3F),
        color5 = Color(0xffEA3469),
        color6 = Color(0xff28D8A3),
        color7 = Color(0xff00BEB2),
    )
)

data class AppColors(
    // Background
    val primary: Color,
    val secondary: Color,

    // Actions, Labels
    val accent_primary: Color,
    val accent_secondary: Color,

    //content
    val content: Color,

    // Actions + content
    val caption: Color,

    // Week colors
    val unique: Unique
) {
    data class Unique(
        val color1: Color,
        val color2: Color,
        val color3: Color,
        val color4: Color,
        val color5: Color,
        val color6: Color,
        val color7: Color,
    )
}

val color_white = Color(0xffffffff)
val color_gray = Color(0xff7f8899)

val color_black = Color(0xff000000)
val color_black_50 = Color(0xff18181c)

val color_blue = Color(0xff335bff)
val color_yellow = Color(0xffffb005)