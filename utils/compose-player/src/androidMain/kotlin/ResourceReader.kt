import java.io.InputStreamReader

actual class ResourceReader {
    actual fun readResource(name: String): String =
        javaClass.classLoader!!.getResourceAsStream(name).use { stream ->
            InputStreamReader(stream).use { reader ->
                reader.readText()
            }
        }

    actual fun readPath(name: String): String {
        return javaClass.classLoader.getResource(name).ref
//        return "android.resource://com.voitenko.usefultraining/${R.raw.intro}"
    }
}