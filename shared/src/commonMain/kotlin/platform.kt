import data.source.AuthProtocol
import data.source.TrainingProtocol
import kotlin.coroutines.CoroutineContext

internal expect class AuthSource() : AuthProtocol
internal expect class TrainingSource() : TrainingProtocol