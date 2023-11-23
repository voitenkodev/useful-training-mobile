package atom

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
        fontSize = 44.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily()
    ),
    H2 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily(),
    ),
    H3 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily()
    ),
    H4 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily(),
        lineHeight = 16.sp
    ),
    H5 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal
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
    Body1 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        lineHeight = 20.sp
    ),
    Body2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        lineHeight = 20.sp
    ),
    Body3 = TextStyle(
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
    val H1: TextStyle, // Welcome titles
    val H2: TextStyle, // Main Toolbar
    val H3: TextStyle, // Sub Main Title
    val H4: TextStyle, // Sub Title ( + Popup Title)
    val H5: TextStyle, // Menu Labels (without custom font)


    val Input: TextStyle, // Main inputs + fields

    val Body1: TextStyle, // Fields
    val Body2: TextStyle, // Fields
    val Body3: TextStyle, // Additional little input

    val Label: TextStyle, // Additional little input

    val PrimaryButton: TextStyle,
    val SecondaryButton: TextStyle,
    val TertiaryButton: TextStyle
)