import dev.icerock.moko.resources.FileResource

actual fun FileResource.toNativeLocalResource() =
    NativeLocalResource(
        this.bundle.resourceURL?.absoluteURL!!
    )