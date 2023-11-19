package atom

import androidx.compose.ui.graphics.Color

internal fun darkPalette() = Color()

public data class Color(
//    val primary: Color = Color(0xff121219),
    val primary: Color = Color(0xff151522),
//    val secondary: Color = Color(0xff1f2129),// default
//    val secondary: Color = Color(0xff1f2424),// green
//    val secondary: Color = Color(0xff172937), // Sea
    val secondary: Color = Color(0xff222238), // Sea dark


    val white5: Color = Color(0x0Dffffff),
    val white10: Color = Color(0x1Affffff),
    val black10: Color = Color(0x33000000),
    val black30: Color = Color(0x80000000),
    val black80: Color = Color(0xCC000000),

    // Text
    val content: Color = Color(0xffffffff),
    val caption: Color = Color(0xffa6a6a6),

    // Accent Primary
    val orange: Color = Color(0xfff74d19),
    val toxic: Color = Color(0xffa3ec3f),

    // Accent Secondary
    val red: Color = Color(0xfff54949),
    val green: Color = Color(0xff37c554),
    val yellow: Color = Color(0xff91c537),
    val purple: Color = Color(0xffa652d0),
    val blue: Color = Color(0xff0079fe)
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