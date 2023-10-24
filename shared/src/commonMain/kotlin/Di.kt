import authentication.authenticationDataModule
import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools
import exercise_example_muscle.ExerciseExamplesSource
import exerciseexample.exerciseExamplesDataModule
import traininig_exercise_iteration.TrainingsSource
import traininigs.trainingsDataModule

public fun initCommonKoin(
    appDeclaration: KoinAppDeclaration = {},
): KoinApplication = KoinPlatformTools.defaultContext().startKoin {
    appDeclaration()
    modules(
        platformModule,
        servicesModule,
        trainingsDataModule,
        authenticationDataModule,
        exerciseExamplesDataModule,
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