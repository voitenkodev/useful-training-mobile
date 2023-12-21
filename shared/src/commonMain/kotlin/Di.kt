import data.authentication.authenticationDataModule
import data.exerciseexamples.exerciseExamplesDataModule
import data.muscles.musclesDataModule
import data.traininigs.trainingsDataModule
import data.user.userDataModule
import exercise_example_muscle.ExerciseExamplesSource
import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools
import traininig_exercise_iteration.TrainingsSource
import user.UserSource

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
        musclesDataModule,
        userDataModule
    )
}

internal val servicesModule = module {
    single { ClientBackend(get()) { get<PreferencesSource>().getToken().firstOrNull() ?: "" } }
    single { PreferencesSource(get()) }
    single { NetworkSource(get()) }
    single { ExerciseExamplesSource(get()) }
    single { TrainingsSource(get()) }
    single { UserSource(get()) }
}