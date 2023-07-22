package mapping

fun Double.toDoubleOrIntString(): String {
    return if (this.compareTo(this.toInt()) == 0) this.toInt().toString()
    else this.toString()
}