public enum class TransitionType { FORWARD, BACK }

public data class NavController(
    val stack: List<Screen> = listOf(),
    val current: Screen? = null,
    val previous: Screen? = null,
    val type: TransitionType? = TransitionType.FORWARD,
)

public open class Screen(public val link: String)
