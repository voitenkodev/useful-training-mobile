import dev.icerock.moko.resources.FileResource

actual fun FileResource.toNativeLocalResource() =
    NativeLocalResource(
        id = this.rawResId
    )