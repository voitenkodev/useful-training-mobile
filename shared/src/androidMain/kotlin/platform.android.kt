import android.app.Application
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import org.koin.dsl.module

internal actual val platformModule = module {
    single { NativeContext(get<Application>()) }
}

internal actual fun Modifier.platformInsets(): Modifier = this
    .statusBarsPadding()
    .systemBarsPadding()