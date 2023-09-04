import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

class Fonts {
    @Composable
    fun fastupRegular() = FontFamily(font("Fastup", "fastup_regular", FontWeight.Normal, FontStyle.Normal))

    @Composable
    fun fastupBold() = FontFamily(font("Fastup", "fastup_bold", FontWeight.Bold, FontStyle.Normal))
}