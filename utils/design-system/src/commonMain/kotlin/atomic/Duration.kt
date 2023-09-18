package atomic

internal fun duration() = Duration(
    animDurationL = 800,
    animDurationM = 500,
    animDurationS = 200,

    animDelayS = 300
)

data class Duration(
    val animDurationS: Int,
    val animDurationM: Int,
    val animDurationL: Int,

    val animDelayS: Int,
)