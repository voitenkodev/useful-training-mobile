package navigation

sealed class Animation {
    object None : Animation()
    data class Push(val animationTime: Int = 300) : Animation()
    data class Present(val animationTime: Int = 300) : Animation()
    data class Fade(val animationTime: Int = 300) : Animation()
}