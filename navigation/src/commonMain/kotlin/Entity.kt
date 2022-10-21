
public sealed class Animation {
    public object None : Animation()
    public data class Push(val animationTime: Int = 300) : Animation()
    public data class Present(val animationTime: Int = 300) : Animation()
    public data class Fade(val animationTime: Int = 300) : Animation()
}