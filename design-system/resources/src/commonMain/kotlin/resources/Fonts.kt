package resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.voitenko.alienworkout.designsystem.resources.Res
import com.voitenko.alienworkout.designsystem.resources.archivo
import org.jetbrains.compose.resources.Font

public object Fonts {

    @Composable
    public fun Primary(): FontFamily {
        return FontFamily(Font(Res.font.archivo))
    }
}