enum class TransitionType { FORWARD, BACK }

data class NavController(
    val stack: List<Screen> = listOf(),
    val current: Screen? = null,
    val previous: Screen? = null,
    val type: TransitionType? = TransitionType.FORWARD,
)

open class Screen(val link: String)
