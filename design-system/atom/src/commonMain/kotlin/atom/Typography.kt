package atom

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import resources.Fonts

@Composable
internal fun typography() = Typography(
    H1 = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily()
    ),
    H2 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.GunterzFamily(),
    ),
    H3 = TextStyle(
        fontSize = 20.sp,
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
    Label = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    Input = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
    ),
    Body1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    Body2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    Body3 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
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
    )
)

public data class Typography(
    val H1: TextStyle, // Welcome titles
    val H2: TextStyle, // Main Toolbar
    val H3: TextStyle, // Sub Main Title
    val H4: TextStyle, // Sub Title ( + Popup Title)

    val Input: TextStyle, // Main inputs + fields

    val Body1: TextStyle, // Fields
    val Body2: TextStyle, // Fields
    val Body3: TextStyle, // Additional little input

    val Label: TextStyle, // Sub titles for sections)

    val PrimaryButton: TextStyle,
    val SecondaryButton: TextStyle,
    val TertiaryButton: TextStyle
)