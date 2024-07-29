package resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily

public object Fonts {

    @Composable
    public fun GunterzFamily(): FontFamily {
        return FontFamily.Default
//        return FontFamily(
//            listOfNotNull(
//                SharedRes.fonts.gunterz.medium.asFont(
//                    weight = FontWeight.Normal,
//                    style = FontStyle.Normal
//                )
//            )
//        )
    }
}