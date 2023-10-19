public actual class NativeLocalResource private actual constructor() {
    public lateinit var url: String
        private set

    public constructor(id: Int) : this() {
        this.url = "android.resource://com.voitenko.usefultraining/${id}"
    }
}