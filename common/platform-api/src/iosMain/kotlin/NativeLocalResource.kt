import platform.Foundation.NSURL

public actual class NativeLocalResource private actual constructor() {
    public lateinit var url: NSURL
        private set

    public constructor(url: NSURL) : this() {
        this.url = url
    }
}