package atom

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import resources.Fonts

@Composable
internal fun typography() = Typography(
    h1 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 32.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.Primary(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        ),
    ),
    h2 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 28.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.Primary(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        ),
    ),
    h3 = TextStyle(
        baselineShift = BaselineShift.None,
        fontSize = 24.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        fontFamily = Fonts.Primary(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        ),
    ),
    h4 = TextStyle(
        baselineShift = BaselineShift.None,
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
    h5 = TextStyle(
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
    textLabel = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    label = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    inputLabel = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    input = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
    ),
    body1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    body2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 20.sp
    ),
    body3 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    body4 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    body5 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal,
    ),
    button = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.sp,
        fontStyle = FontStyle.Normal,
    ),
    textButton = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
    )
)

public data class Typography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,

    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val body5: TextStyle,

    @Deprecated("Use Label")
    val textLabel: TextStyle, // Sub titles for sections)

    val label: TextStyle,
    val input: TextStyle,
    val inputLabel: TextStyle,

    val button: TextStyle,
    val textButton: TextStyle
)