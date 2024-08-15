package atom

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import resources.Fonts

@Composable
internal fun typography() = Typography(
    H1 = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = 2.sp,
        fontFamily = Fonts.Primary(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        ),
    ),
    H2 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 30.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.Primary(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        ),
    ),
    H3 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.Primary(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        )
    ),
    H4 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.Primary(),
        letterSpacing = 1.sp,
        lineHeight = 16.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        ),
    ),
    TextLabel = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    Label = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    InputLabel = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    Input = TextStyle(
        fontSize = 16.sp,
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
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ),
    Body4 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    Button = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.sp,
        fontStyle = FontStyle.Normal,
    ),
    TertiaryButton = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
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
    val Body4: TextStyle, // Additional little input

    @Deprecated("Use Label")
    val TextLabel: TextStyle, // Sub titles for sections)

    val Label: TextStyle, // Sub titles for sections)
    val InputLabel: TextStyle, // Sub titles for sections)

    val Button: TextStyle,
    val TertiaryButton: TextStyle
)