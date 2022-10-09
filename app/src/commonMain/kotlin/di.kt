import data.repository.TrainingRepository
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

val appModule = module {
    single(named("DEFAULT")) { defaultDispatcher }
    single(named("IO")) { defaultDispatcher }
    single(named("MAIN")) { uiDispatcher }

    single { AuthSource() } bind AuthProtocol::class
    single { TrainingSource() } bind TrainingProtocol::class

    single { TrainingRepository(get(), get()) }
}