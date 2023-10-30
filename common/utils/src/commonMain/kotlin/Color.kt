import androidx.compose.ui.graphics.Color
import kotlin.random.Random

public object ColorUtils {
    public fun randomColor(from: Int = 60, until: Int = 188): Color {
        val random = Random
        val red = random.nextInt(from, until)
        val green = random.nextInt(from, until)
        val blue = random.nextInt(from, until)
        return Color(red, green, blue)
    }
}