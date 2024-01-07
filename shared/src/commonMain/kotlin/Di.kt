import data.dataModule
import data.user.userDataModule
import exercise_examples.ExerciseExamplesSource
import kotlinx.coroutines.flow.firstOrNull
import equipments.EquipmentsSource
import muscles.MusclesSource
import network.ClientBackend
import network.NetworkSource
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
        dataModule,
        userDataModule
    )
}

internal val servicesModule = module {
    single { ClientBackend(get()) { get<PreferencesSource>().getToken().firstOrNull() ?: "" } }
    single { PreferencesSource(get()) }
    single { NetworkSource(get()) }
    single { ExerciseExamplesSource(get()) }
    single { EquipmentsSource(get()) }
    single { MusclesSource(get()) }
    single { TrainingsSource(get()) }
    single { UserSource(get()) }
}