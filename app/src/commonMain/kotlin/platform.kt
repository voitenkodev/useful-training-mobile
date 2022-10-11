import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.source.AuthProtocol
import data.source.TrainingProtocol
import org.koin.core.module.Module
import kotlin.coroutines.CoroutineContext




expect class AuthSource() : AuthProtocol
expect class TrainingSource() : TrainingProtocol