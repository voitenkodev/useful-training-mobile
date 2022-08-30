package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GallerySpaceLightPalette() = GallerySpaceColor(
    primary = white,
    primaryInverse = almostBlack,
    secondary = almostWhite,
    shadow = darkGray,
    caption = lightGray,
    priceUp = green,
    priceDown = red
)

@Composable
fun GallerySpaceDarkPalette() = GallerySpaceColor(
    primary = almostBlack,
    primaryInverse = almostWhite,
    secondary = black,
    shadow = darkGray,
    caption = lightGray,
    priceUp = green,
    priceDown = red
)

data class GallerySpaceColor(
    val primary: Color, // black - white
    val primaryInverse: Color, // black - white
    val secondary: Color, //white - black
    val shadow: Color, // darkgray - darkgray
    val caption: Color,// lightgray - lightgray
    val priceUp: Color,
    val priceDown: Color,
)

internal val black = Color(0xff000000)
internal val white = Color(0xffffffff)

internal val almostWhite = Color(0xFFF1F1F1)
internal val almostBlack = Color(0xFF121311)

internal val darkGray = Color(0xFF1F1F1F)
internal val lightGray = Color(0xFF585858)

internal val yellow = Color(0xFFECBE6E)
internal val green = Color(0xFF228D57)
internal val red = Color(0xFFEA3469)