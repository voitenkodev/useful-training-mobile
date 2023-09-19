import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools
import repository.AuthRepository
import repository.AuthRepositoryImpl
import repository.TrainingRepository
import repository.TrainingRepositoryImpl
import source.database.DataBaseSource
import source.datastore.PreferencesSource
import source.network.ClientBackend
import source.network.NetworkSource

fun initCommonKoin(
    appDeclaration: KoinAppDeclaration = {},
) = KoinPlatformTools.defaultContext().startKoin {
    appDeclaration()
    modules(platformModule, appModule)
}

val appModule = module {

    single { ClientBackend(get(), get()) }

    single { PreferencesSource(get()) }
    single { NetworkSource(get()) }
    single { DataBaseSource(get()) }

    single { TrainingRepositoryImpl(get(), get()) } bind TrainingRepository::class
    single { AuthRepositoryImpl(get(), get(), get()) } bind AuthRepository::class
}