import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.source.AuthProtocol
import data.source.TrainingProtocol
import org.koin.core.module.Module
import kotlin.coroutines.CoroutineContext

@Composable
expect fun BackHandler(action: () -> Unit)

@Composable
expect fun RemoteImage(imageUrl: String, modifier: Modifier, contentDescription: String?)

expect class AuthSource() : AuthProtocol
expect class TrainingSource() : TrainingProtocol

expect val defaultDispatcher: CoroutineContext

expect val ioDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext