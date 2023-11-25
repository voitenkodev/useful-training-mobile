import kotlin.math.pow

public fun Int.kg(): String {
    val factor = 10.0f.pow(1)
    return "${(this.toFloat() / factor)}kg"
}

public fun Int.meter(): String {
    val factor = 10.0.pow(2)
    val floatString = (this.toFloat() / factor).toString()
    val parts = floatString.split(".")
    val decimalPart = parts[1]

    val value = when (decimalPart.length) {
        0 -> "${parts[0]}.00"
        1 -> "${parts[0]}.${decimalPart}0"
        2 -> "${parts[0]}.${decimalPart}"
        else -> null
    }

    return "${value ?: floatString}m"
}

public fun Int.percents(): String {
    return "$this%"
}

public fun Int.minutes(): String {
    return "$this min"
}