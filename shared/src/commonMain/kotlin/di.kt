import data.repository.AuthRepository
import data.repository.AuthRepositoryImpl
import data.repository.TrainingRepository
import data.repository.TrainingRepositoryImpl
import data.source.AuthProtocol
import data.source.AuthSource
import data.source.Client
import data.source.TrainingProtocol
import data.source.TrainingSource
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools

fun initCommonKoin(appDeclaration: KoinAppDeclaration = {}) =
    KoinPlatformTools
        .defaultContext()
        .startKoin {
            appDeclaration()
            modules(appModule)
        }

internal fun globalKoin() =
    KoinPlatformTools
        .defaultContext()
        .get()

internal val appModule = module {
    single { AuthSource(get()) } bind AuthProtocol::class
    single { TrainingSource(get()) } bind TrainingProtocol::class
    single { TrainingRepositoryImpl(get(), get()) } bind TrainingRepository::class
    single { AuthRepositoryImpl(get()) } bind AuthRepository::class
    single { Client.address() }
}