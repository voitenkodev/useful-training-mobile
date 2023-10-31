/**
 * Round double value
 */
public fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}

public fun Float.isInteger(): Boolean {
    val intValue = this.toInt()
    return (this - intValue.toFloat()).toInt() == 0
}

/**
 * Map 15.0 to `15` and 15.2 to `15.2`
 */
public fun Double.toDoubleOrIntString(): String {
    return if (this.compareTo(this.toInt()) == 0) this.toInt().toString()
    else this.toString()
}