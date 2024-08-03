import kotlin.math.abs

public fun Double.toShortNumber(): String {
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

public fun Double.kg(allowUnit: Boolean): String {
    return if (allowUnit) "${this.toShortNumber()} kg"
    else this.toShortNumber()
}

public fun Double.meter(allowUnit: Boolean): String {
    val floatString = this.toString()
    val parts = floatString.split(".")
    val decimalPart = parts[1]

    val value = when (decimalPart.length) {
        0 -> "${parts[0]}.00"
        1 -> "${parts[0]}.${decimalPart}0"
        2 -> "${parts[0]}.${decimalPart}"
        else -> null
    }

    return if (allowUnit) "${value ?: floatString} m" else value ?: floatString
}

public fun Number.percents(): String {
    return "${this.toInt()}%"
}