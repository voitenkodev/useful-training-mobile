import androidx.compose.runtime.Composable
import org.koin.dsl.module

internal actual val platformModule = module {
    single { NativeContext() }
}

@Composable
internal actual fun PlatformBackHandler(action: () -> Unit) {
}