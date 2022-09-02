package ui.designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.sp

@ExperimentalUnitApi
@Composable
internal fun AppTypography() = AppTypography(
    H1 = TextStyle(
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ), BODY1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ), BUTTON = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    )
)

data class AppTypography(
    val H1: TextStyle,
    val BODY1: TextStyle,
    val BUTTON: TextStyle,
)