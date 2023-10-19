import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext

public expect open class ViewModel() : InstanceKeeper.Instance, CoroutineScope, KoinComponent {
    override val coroutineContext: CoroutineContext
}
