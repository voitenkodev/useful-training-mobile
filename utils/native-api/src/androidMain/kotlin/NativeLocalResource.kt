actual class NativeLocalResource private actual constructor() {
    lateinit var url: String
        private set

    constructor(id: Int) : this() {
        this.url = "android.resource://com.voitenko.usefultraining/${id}"
    }
}