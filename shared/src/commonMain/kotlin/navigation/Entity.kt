package navigation

internal sealed class Animation {
    internal object None : Animation()
    internal data class Push(val animationTime: Int = 300) : Animation()
    internal data class Present(val animationTime: Int = 300) : Animation()
    internal data class Fade(val animationTime: Int = 300) : Animation()
}