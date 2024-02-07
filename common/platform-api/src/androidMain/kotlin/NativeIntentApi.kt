import android.content.Intent
import android.net.Uri

public actual class NativeIntentApi actual constructor(public actual val nativeContext: NativeContext) {

    public actual fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        if (intent.resolveActivity(nativeContext.context.packageManager) != null) {
        nativeContext.context.startActivity(intent)
//        }
    }
}