sealed class AnimationType {
    object None : AnimationType()
    data class Push(val animationTime: Int = 300) : AnimationType()
    data class Present(val animationTime: Int = 300) : AnimationType()
    data class Fade(val animationTime: Int = 300) : AnimationType()
}