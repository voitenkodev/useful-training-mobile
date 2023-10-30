import kotlin.math.abs

public fun Double.toShortString(): String {
    val absValue = abs(this)

    return when {
        absValue >= 1_000_000 -> {
            val rounded = (absValue / 1_000_000).round(1)

            val value = if (rounded % 1.0 == 0.0) {
                rounded.toInt().toString()
            } else {
                rounded.toString()
            }
            value + "M"
        }

        absValue >= 1_000 -> {
            val rounded = (absValue / 1_000).round(1)

            val value = if (rounded % 1.0 == 0.0) {
                rounded.toInt().toString()
            } else {
                rounded.toString()
            }
            value + "K"
        }

        else -> this.toString()
    }
}