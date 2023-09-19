import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.voitenko.usefultraining.SharedRes
import dev.icerock.moko.resources.compose.asFont

object Fonts {

    @Composable
    fun ArchivoFamily(): FontFamily {
        return FontFamily(
            listOfNotNull(
                SharedRes.fonts.archivo.regular.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Normal
                )
            )
        )
    }
}