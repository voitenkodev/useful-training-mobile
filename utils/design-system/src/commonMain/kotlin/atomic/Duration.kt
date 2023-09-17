package atomic

internal fun duration() = Duration(
    animL = 10,
    animM = 800,
    animS = 500
)

data class Duration(
    val animS: Int,
    val animM: Int,
    val animL: Int,
)