import android.content.Context

public actual class NativeContext private actual constructor() {
    public lateinit var context: Context
        private set

    public constructor(context: Context) : this() {
        this.context = context
    }
}