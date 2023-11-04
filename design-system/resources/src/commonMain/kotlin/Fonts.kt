import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.voitenko.alienworkout.SharedRes
import dev.icerock.moko.resources.compose.asFont

public object Fonts {

    @Composable
    public fun GunterzFamily(): FontFamily {
        return FontFamily(
            listOfNotNull(
                SharedRes.fonts.gunterz.medium.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Normal
                )
            )
        )
    }
}