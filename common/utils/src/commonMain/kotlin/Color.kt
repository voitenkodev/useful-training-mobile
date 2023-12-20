import androidx.compose.ui.graphics.Color
import kotlin.random.Random

public object ColorUtils {
    private const val VARIATION_COEFFICIENT = 0.2

    public fun randomColor(from: Int = 60, until: Int = 188): Color {
        val random = Random
        val baseRed = random.nextInt(from, until)
        val baseGreen = random.nextInt(from, until)
        val baseBlue = random.nextInt(from, until)

        val variation = ((until - from) * VARIATION_COEFFICIENT).toInt()

        val red = clamp(baseRed + random.nextInt(-variation, variation + 1), 0, 255)
        val green = clamp(baseGreen + random.nextInt(-variation, variation + 1), 0, 255)
        val blue = clamp(baseBlue + random.nextInt(-variation, variation + 1), 0, 255)

        return Color(red, green, blue)
    }

    private fun clamp(value: Int, min: Int, max: Int): Int {
        return when {
            value < min -> min
            value > max -> max
            else -> value
        }
    }
}