import data.repository.AuthRepository
import data.repository.AuthRepositoryImpl
import data.repository.TrainingRepository
import data.repository.TrainingRepositoryImpl
import data.source.AuthProtocol
import data.source.TrainingProtocol
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.mp.KoinPlatformTools

fun initCommonKoin(
    appDeclaration: KoinAppDeclaration = {},
) = KoinPlatformTools.defaultContext().startKoin {
    appDeclaration()
    modules(appModule)
}

fun globalKoin() = KoinPlatformTools.defaultContext().get()

val appModule = module {

    single { AuthSource() } bind AuthProtocol::class
    single { TrainingSource() } bind TrainingProtocol::class

    single(named("DEFAULT")) { defaultDispatcher }
    single(named("IO")) { defaultDispatcher }
    single(named("MAIN")) { uiDispatcher }

    single { TrainingRepositoryImpl(get(), get(), get(named("IO"))) } bind TrainingRepository::class
    single { AuthRepositoryImpl(get(), get(named("IO"))) } bind AuthRepository::class
}