import data.repository.AuthRepository
import data.repository.AuthRepositoryImpl
import data.repository.TrainingRepository
import data.repository.TrainingRepositoryImpl
import data.source.database.LocalDataSource
import data.source.network.RemoteDataSource
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools

fun initCommonKoin(
    appDeclaration: KoinAppDeclaration = {},
) = KoinPlatformTools.defaultContext().startKoin {
    appDeclaration()
    modules(platformModule, appModule)
}

fun globalKoin() = KoinPlatformTools.defaultContext().get()

val appModule = module {
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
    single { TrainingRepositoryImpl(get(), get()) } bind TrainingRepository::class
    single { AuthRepositoryImpl(get(), get()) } bind AuthRepository::class
}