package design.atomic

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

internal fun appTypography() = AppTypography(
    H1 = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ),
    H2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    Body = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    Body2 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    PrimaryButton = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    SecondaryButton = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textDecoration = TextDecoration.Underline
    )
)

data class AppTypography(
    val H1: TextStyle, // big titles
    val H2: TextStyle, // little titles

    val Body: TextStyle, // main inputs + fields
    val Body2: TextStyle, // additional little input

    val PrimaryButton: TextStyle,
    val SecondaryButton: TextStyle,
)

