import platform.Foundation.NSBundle

actual class VideoManager actual constructor(nativeContext: NativeContext) {
    actual fun getLocalVideoPath(): String? {
        return NSBundle.mainBundle.pathForResource("video", "mp4")
    }
}