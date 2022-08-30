package designsystem.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.sp

@ExperimentalUnitApi
@Composable
internal fun GallerySpaceTypography() = AppTypography(
    H1 = TextStyle(
        fontSize = 40.sp,
//        fontFamily = Grenoble,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ),
    H2 = TextStyle(
        fontSize = 30.sp,
//        fontFamily = Grenoble,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    ),
    BODY1 = TextStyle(
        fontSize = 16.sp,
//        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    BODY2 = TextStyle(
        fontSize = 16.sp,
//        fontFamily = TheSeasons,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    CAPTION1 = TextStyle(
        fontSize = 14.sp,
//        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
    BUTTON = TextStyle(
        fontSize = 16.sp,
//        fontFamily = TheSeasons,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    )
)

data class AppTypography(
    val H1: TextStyle,
    val H2: TextStyle,
    val BODY1: TextStyle,
    val BODY2: TextStyle,
    val CAPTION1: TextStyle,
    val BUTTON: TextStyle,
)
//
//private val TheSeasons = FontFamily(
//    Font(R.font.the_seasons_bold, FontWeight.Bold, FontStyle.Normal),
//    Font(R.font.the_seasons_bold_italic, FontWeight.Bold, FontStyle.Italic),
//    Font(R.font.the_seasons_italic, FontWeight.Normal, FontStyle.Italic),
//    Font(R.font.the_seasons_light, FontWeight.Light, FontStyle.Normal),
//    Font(R.font.the_seasons_light_italic, FontWeight.Light, FontStyle.Italic),
//    Font(R.font.the_seasons_regular, FontWeight.Normal, FontStyle.Normal)
//)
//private val PtSans = FontFamily(
//    Font(R.font.pt_sans_bold, FontWeight.Bold, FontStyle.Normal),
//    Font(R.font.pt_sans_bold_italic, FontWeight.Bold, FontStyle.Italic),
//    Font(R.font.pt_sans_italic, FontWeight.Normal, FontStyle.Italic),
//    Font(R.font.pt_sans_regular, FontWeight.Normal, FontStyle.Normal),
//)
//private val Grenoble = FontFamily(
//    Font(R.font.grenoble_bold, FontWeight.Bold, FontStyle.Normal),
//    Font(R.font.grenoble_bold_italic, FontWeight.Bold, FontStyle.Italic),
//    Font(R.font.grenoble_italic, FontWeight.Normal, FontStyle.Italic),
//    Font(R.font.grenoble_regular, FontWeight.Normal, FontStyle.Normal),
//)