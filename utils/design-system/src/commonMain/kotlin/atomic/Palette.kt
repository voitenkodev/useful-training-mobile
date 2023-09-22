package atomic

import Design
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

internal fun darkPalette() = Color()

data class Color(
    // Background
    val primary: Color = Color(0xff000000),
    val secondary: Color = Color(0xff13131c),
    val tertiary: Color = Color(0x0Dffffff),

    // Color(0xffEA3469) = Red / Pink
    // Color(0xff228D57) = Green soft
    // Color(0xff31353b) = Gray
    // Color(0xfffcb51c) = Yellow
    // Color(0xff335bff) = Blue

    // Accent
    val accent_primary: Color = Color(0xff335bff),
    val accent_secondary: Color = Color(0xffEA3469),
    val accent_tertiary: Color = Color(0xff228D57),
    val accent_quaternary: Color = Color(0xffb45ac4),
    val accent_quinary: Color = Color(0xfffcb51c),

    // Text
    val content: Color = Color(0xffffffff),
    val caption: Color = Color(0xffa6a6a6),
)

@Composable
fun rememberAccentColorsAsState(): State<List<Color>> {
    return rememberUpdatedState(
        listOf(
            Design.colors.accent_primary,
            Design.colors.accent_secondary,
            Design.colors.accent_tertiary,
            Design.colors.accent_quaternary,
            Design.colors.accent_quinary,
        )
    )
}

/*
100% — FF
95% — F2
90% — E6
85% — D9
80% — CC
75% — BF
70% — B3
65% — A6
60% — 99
55% — 8C
50% — 80
45% — 73
40% — 66
35% — 59
30% — 4D
25% — 40
20% — 33
15% — 26
10% — 1A
5% — 0D
0% — 00
*/