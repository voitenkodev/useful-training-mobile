import kotlin.math.pow

public fun Int.grToKg(): Double {
    val factor = 10.0.pow(1)
    return (this / factor)
}

public fun Double.kgToGr(): Int {
    val factor = 10.0.pow(1)
    return (this * factor).toInt()
}

public fun Int.cmToM(): Double {
    val factor = 10.0.pow(2)
    return (this.toFloat() / factor)
}