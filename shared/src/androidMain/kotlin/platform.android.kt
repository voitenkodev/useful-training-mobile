import android.app.Application
import org.koin.dsl.module

internal actual val platformModule = module {
    single { NativeContext(get<Application>()) }
    single { NativeIntentApi(get<NativeContext>()) }
}