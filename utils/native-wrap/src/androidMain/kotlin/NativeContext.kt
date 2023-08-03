import android.content.Context

actual class NativeContext private actual constructor() {
    lateinit var context: Context
        private set

    constructor(context: Context) : this() {
        this.context = context
    }
}