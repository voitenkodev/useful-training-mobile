import kotlin.math.abs

fun Double.toShortString(): String {
    val absValue = abs(this)
    return when {
        absValue >= 1_000_000 -> "${(this / 1_000_000).toInt()}M"
        absValue >= 1_000 -> "${(this / 1_000).toInt()}K"
        else -> this.toString()
    }
}