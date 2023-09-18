package atomic

internal fun duration() = Duration(
    animL = 800,
    animM = 500,
    animS = 500
)

data class Duration(
    val animS: Int,
    val animM: Int,
    val animL: Int,
)