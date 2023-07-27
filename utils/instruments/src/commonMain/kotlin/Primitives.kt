package utils

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}

fun Double.toDoubleOrIntString(): String {
    return if (this.compareTo(this.toInt()) == 0) this.toInt().toString()
    else this.toString()
}