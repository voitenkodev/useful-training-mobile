import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
public data class SavedState(val value: Parcelable) : Parcelable

@Suppress("UNCHECKED_CAST")
public class SavedStateHandle(default: SavedState?) : InstanceKeeper.Instance {
    private var savedState: SavedState? = default
    public val value: Parcelable? get() = savedState
    public fun <T : Parcelable> get(): T? = savedState?.value as? T?
    public fun set(value: Parcelable) {
        this.savedState = SavedState(value)
    }

    override fun onDestroy() {
        savedState = null
    }
}
