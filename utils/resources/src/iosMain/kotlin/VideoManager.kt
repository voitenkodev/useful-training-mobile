import platform.Foundation.NSBundle

actual object VideoManager {
    actual fun getLocalVideoPath(name:String, type: String): String? {
        return NSBundle.mainBundle.pathForResource("utils/resources/video/$name", type)
    }
}