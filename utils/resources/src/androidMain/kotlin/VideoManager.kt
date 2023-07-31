actual object VideoManager {
    actual fun getLocalVideoPath(name:String, type: String): String? {
        return "android.resource://com.voitenko.usefultraining.utils.resources/videos/$name.$type"
    }
}