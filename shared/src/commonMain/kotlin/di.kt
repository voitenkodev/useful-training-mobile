import kotlinx.coroutines.flow.firstOrNull
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools

fun initCommonKoin(
    appDeclaration: KoinAppDeclaration = {},
) = KoinPlatformTools.defaultContext().startKoin {
    appDeclaration()
    modules(
        platformModule,
        servicesModule,
        dataTrainingsModule,
        dataAuthenticationModule,
    )
}

val servicesModule = module {
    single {
        ClientBackend(get()) {
            get<PreferencesSource>().getToken().firstOrNull() ?: ""
        }
    }
    single { PreferencesSource(get()) }
    single { NetworkSource(get()) }
    single { DataBaseSource(get()) }
}