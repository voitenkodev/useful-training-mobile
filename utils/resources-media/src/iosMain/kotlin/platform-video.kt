import dev.icerock.moko.resources.FileResource

internal actual fun FileResource.toNativeLocalResource() = NativeLocalResource(
    this.url
)
