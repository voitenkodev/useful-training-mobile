package atomic

import androidx.compose.ui.graphics.Color

internal fun darkPalette() = AppColors(
    primary = color_black,
    secondary = color_black_50,
    tertiary = color_black_100,

    accent_primary = color_blue,
    accent_secondary = color_yellow,
    accent_tertiary = color_red,

    content = color_white,
    caption = color_gray,

    unique = AppColors.Unique(
        color1 = Color(0xff228D57),
        color2 = Color(0xff00838f),
        color3 = Color(0xff512da8),
        color4 = Color(0xffD5BD3F),
        color5 = Color(0xffEA3469),
        color6 = Color(0xff7b1fa2),
        color7 = Color(0xff00BEB2),

        color8 = Color(0xff32a852),
        color9 = Color(0xffb45ac4),
        color10 = Color(0xffedb640),

        color11 = Color(0xffed4057),
        color12 = Color(0xfff58438),
    )
)

data class AppColors(
    // Background
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,

    // Actions, Labels
    val accent_primary: Color, // blue
    val accent_secondary: Color, // yellow
    val accent_tertiary: Color, // red

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
        val color8: Color,
        val color9: Color,
        val color10: Color,
        val color11: Color,
        val color12: Color,
    ) {
        fun asList() = listOf(color1, color2, color3, color4, color5, color6, color7, color8, color9, color10, color11, color12)
    }
}

val color_white = Color(0xffffffff)
val color_gray = Color(0xff77808f)

val color_black = Color(0xff000000)

val color_black_50 = Color(0xff13131c)
val color_black_100 = Color(0xff101014)

val color_blue = Color(0xff31353b)
val color_yellow = Color(0xffffb005)
val color_red = Color(0xffEA3469)