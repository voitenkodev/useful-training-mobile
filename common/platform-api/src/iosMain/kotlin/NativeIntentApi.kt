import platform.Foundation.NSURL.Companion.URLWithString
import platform.UIKit.UIApplication

public actual class NativeIntentApi actual constructor(public actual val nativeContext: NativeContext) {

    public actual fun openBrowser(url: String) {
        UIApplication.sharedApplication().openURL(URLWithString(url)!!)
    }
}