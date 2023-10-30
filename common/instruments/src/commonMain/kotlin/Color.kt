import androidx.compose.ui.graphics.Color
import kotlin.random.Random

public object ColorUtils {
    public fun randomColor(): Color {
        val random = Random
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return Color(red, green, blue)
    }
}