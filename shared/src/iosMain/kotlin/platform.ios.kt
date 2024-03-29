import org.koin.dsl.module

internal actual val platformModule = module {
    single { NativeContext() }
    single { NativeIntentApi(get<NativeContext>()) }
}