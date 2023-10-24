import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools
import exercise_example_muscle.ExerciseExamplesSource
import traininig_exercise_iteration.TrainingsSource

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
    single { ExerciseExamplesSource(get()) }
    single { TrainingsSource(get()) }
}