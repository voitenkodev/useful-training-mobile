actual class VideoManager actual constructor(nativeContext: NativeContext) {
    actual fun getLocalVideoPath(): String? {
        return "file:///android_asset/videos/video.mp4"
    }
}