public sealed class AnimationType {
    public object None : AnimationType()
    public data class Push(val animationTime: Int = 300) : AnimationType()
    public data class Present(val animationTime: Int = 300) : AnimationType()
    public data class Fade(val animationTime: Int = 300) : AnimationType()
}