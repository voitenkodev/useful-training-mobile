package atom

import androidx.compose.ui.graphics.Color

internal fun darkPalette() = Color()

public data class Color(
    val primary: Color = Color(0xff15171C), // +
    val secondary: Color = Color(0xff1D1F27), // +
    val tertiary: Color = Color(0xff272932), // +

    val orange: Color = Color(0xffE54D6D), // +
    val yellow: Color = Color(0xffECCA55), // +
    val green: Color = Color(0xff50B060), // +
    val red: Color = Color(0xffD14C66), // +

    // Text
    val content: Color = Color(0xFFFFFFFF), // +
    val label: Color = Color(0xff7E8288), // +

    val white5: Color = Color(0x0DFCFBFA), // Shadow + Borders
    val white10: Color = Color(0x1AFCFBFA),
    val white30: Color = Color(0x4DFCFBFA),
    val white50: Color = Color(0x80FCFBFA),
    val black10: Color = Color(0x33000000),
    val black30: Color = Color(0x80000000), // shadow on images
    val black70: Color = Color(0xB3000000), // Background shadow (popups)


    // Accent Secondary
)

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