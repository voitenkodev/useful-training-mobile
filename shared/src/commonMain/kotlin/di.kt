import data.repository.AuthRepository
import data.repository.AuthRepositoryImpl
import data.repository.TrainingRepository
import data.repository.TrainingRepositoryImpl
import data.source.network.AuthProtocol
import data.source.network.AuthSource
import data.source.network.TrainingProtocol
import data.source.network.TrainingSource
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
    single { AuthSource(get(), get()) } bind AuthProtocol::class
    single { TrainingSource(get()) } bind TrainingProtocol::class
    single { TrainingRepositoryImpl(get()) } bind TrainingRepository::class
    single { AuthRepositoryImpl(get()) } bind AuthRepository::class
}