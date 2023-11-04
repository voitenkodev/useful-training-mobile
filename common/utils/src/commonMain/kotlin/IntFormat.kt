public fun Int.intToFloatWithDecimal(decimalPlaces: Int): Float {
    val factor = 10.0f.pow(decimalPlaces)
    return (this.toFloat() / factor)
}

private fun Float.pow(exponent: Int): Float {
    var result = 1.0f
    for (i in 0 until exponent) {
        result *= this
    }
    return result
}