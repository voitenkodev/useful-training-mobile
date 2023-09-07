import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.voitenko.usefultraining.SharedRes
import dev.icerock.moko.resources.compose.asFont

object Fonts {

    @Composable
    fun FastupFontFamily(): FontFamily {
        return FontFamily(
            listOfNotNull(
                SharedRes.fonts.fastup.bold.asFont(
                    weight = FontWeight.Bold,
                    style = FontStyle.Normal
                ),
                SharedRes.fonts.fastup.regular.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Normal
                )
            )
        )
    }

    @Composable
    fun AmfibiaFontFamily(): FontFamily {
        return FontFamily(
            listOfNotNull(
                SharedRes.fonts.amfibia.bold.asFont(
                    weight = FontWeight.Bold,
                    style = FontStyle.Normal
                ),
                SharedRes.fonts.amfibia.regular.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Normal
                ),
                SharedRes.fonts.amfibia.extraBold.asFont(
                    weight = FontWeight.ExtraBold,
                    style = FontStyle.Normal
                ),
                SharedRes.fonts.amfibia.thin.asFont(
                    weight = FontWeight.Thin,
                    style = FontStyle.Normal
                ),
                SharedRes.fonts.amfibia.light.asFont(
                    weight = FontWeight.Light,
                    style = FontStyle.Normal
                ),
            )
        )
    }
}