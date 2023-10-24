package atomic

import Fonts
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
internal fun typography() = Typography(
    H1 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily(),
    ),
    H2 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily()
    ),
    H3 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily()
    ),
    H4 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily(),
        lineHeight = 18.sp
    ),
    Label = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
    ),
    Input = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default
    ),
    Body = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default
    ),
    Body2 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default
    ),
    PrimaryButton = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ),
    SecondaryButton = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ),
    TertiaryButton = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textDecoration = TextDecoration.Underline,
        fontFamily = FontFamily.Default
    )
)

public data class Typography(
    val H1: TextStyle, // big titles
    val H2: TextStyle, // medium titles
    val H3: TextStyle, // little titles
    val H4: TextStyle, // little titles

    val Input: TextStyle, // main inputs + fields

    val Body: TextStyle, // fields
    val Body2: TextStyle, // additional little input

    val Label: TextStyle, // additional little input

    val PrimaryButton: TextStyle,
    val SecondaryButton: TextStyle,
    val TertiaryButton: TextStyle,
)

