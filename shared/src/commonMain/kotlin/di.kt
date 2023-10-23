import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools

public fun initCommonKoin(
    appDeclaration: KoinAppDeclaration = {},
): KoinApplication = KoinPlatformTools.defaultContext().startKoin {
    appDeclaration()
    modules(
        platformModule,
        servicesModule,
        trainingsDataDiModule,
        authDataDiModule,
        exerciseExamplesDataDiModule,
    )
}

internal val servicesModule = module {
    single {
        ClientBackend(get()) {
            get<PreferencesSource>().getToken().firstOrNull() ?: ""
        }
    }
    single { PreferencesSource(get()) }
    single { NetworkSource(get()) }
    single { DataBaseSource(get()) }
}