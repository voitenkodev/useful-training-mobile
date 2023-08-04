import platform.Foundation.NSURL

actual class NativeLocalResource private actual constructor() {
    lateinit var url: NSURL
        private set

    constructor(url: NSURL) : this() {
        this.url = url
    }
}